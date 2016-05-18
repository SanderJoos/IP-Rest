/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip.ip.rest.controller;

import entities.Author;
import entities.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.ServiceFacade;

/**
 *
 * @author Sander_2
 */
@RestController
@RequestMapping("/author")
public class AuthorRestController {

    @Autowired
    ServiceFacade service;
  
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addAuthor(@RequestBody Author author){
        service.addAuthor(author);
    }
  
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Author> getAuthors(){
        return service.getAllAuthors();
    }   
    
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateAuthor(@RequestBody Author author){
        service.updateAuthor(author);
    }
    
    @RequestMapping(value="/id", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAuthor(@PathVariable long id){
        service.deleteAuthor(id);
    }
    
    @RequestMapping(value="/id", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Author getAuthor(@PathVariable long id){
        return service.getAuthorById(id);
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks(@PathVariable long id){
        return service.getAuthorById(id).getBooks();
    }
    
    @RequestMapping(value="/addBook/{id}",method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBook(Book book, @PathVariable long id){
        service.addBookToAuthor(service.getAuthorById(id), book);
    }
}

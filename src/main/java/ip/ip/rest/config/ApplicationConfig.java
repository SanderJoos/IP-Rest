/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip.ip.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import services.ServiceFacade;

/**
 *
 * @author Sander_2
 */
@Configuration
@ComponentScan("ip.ip.rest.controller")
@EnableWebMvc 
public class ApplicationConfig {
    @Bean
     public ServiceFacade service() {
         return new ServiceFacade("postgresql");
     }
}

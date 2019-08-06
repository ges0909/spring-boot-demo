package de.schrader.springbootdemo;

import de.schrader.springbootdemo.service.PersonService;
import de.schrader.springbootdemo.service.PersonServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
}

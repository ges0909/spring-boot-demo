package de.schrader.spring.boot.demo.service;

import de.schrader.spring.boot.demo.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Person getByName(String name);
}

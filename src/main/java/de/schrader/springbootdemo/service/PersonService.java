package de.schrader.springbootdemo.service;

import de.schrader.springbootdemo.dto.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Person getPerson(String name);
}

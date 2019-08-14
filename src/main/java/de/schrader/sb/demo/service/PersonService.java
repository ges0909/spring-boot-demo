package de.schrader.sb.demo.service;

import de.schrader.sb.demo.dto.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Person getPerson(String name);
}

package de.schrader.spring.boot.demo.service;

import de.schrader.spring.boot.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getAllPersons();

    Optional<Person> getPerson(String name);

    Person createPerson(Person person);

    Person updatePerson(Person person);

    void deletePerson(String name);
}

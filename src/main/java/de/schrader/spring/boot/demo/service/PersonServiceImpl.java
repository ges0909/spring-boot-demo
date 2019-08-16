package de.schrader.spring.boot.demo.service;

import de.schrader.spring.boot.demo.model.Person;
import de.schrader.spring.boot.demo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getByName(String name) {
        return personRepository.findByName(name);
    }
}

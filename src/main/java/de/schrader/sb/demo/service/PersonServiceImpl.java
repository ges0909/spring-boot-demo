package de.schrader.sb.demo.service;

import de.schrader.sb.demo.dto.Person;

public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPerson(String name) {
        return new Person("Vinzenz", 20);
    }
}

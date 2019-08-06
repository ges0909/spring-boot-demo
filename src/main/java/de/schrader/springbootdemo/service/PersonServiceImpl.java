package de.schrader.springbootdemo.service;

import de.schrader.springbootdemo.dto.Person;

public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPerson(String name) {
        return new Person("Vinzenz", 20);
    }
}

package de.schrader.spring.boot.demo;

import de.schrader.spring.boot.demo.model.Person;

class TestPerson {

    static Person of(String name, int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        return person;
    }
}

package de.schrader.sb.demo.controller;

import de.schrader.sb.demo.service.PersonService;
import de.schrader.sb.demo.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonControllerImpl implements PersonController {

    private PersonService personService;

    @Autowired
    PersonControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Person getPerson(@PathVariable String name) {
        return personService.getPerson(name);
    }
}

package de.schrader.spring.boot.demo.rest;

import de.schrader.spring.boot.demo.dto.PersonDto;
import de.schrader.spring.boot.demo.model.Person;
import de.schrader.spring.boot.demo.service.PersonService;
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
    public PersonDto getPerson(@PathVariable String name) {
        Person person = personService.getByName(name);
        return new PersonDto();
    }
}

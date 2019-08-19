package de.schrader.spring.boot.demo.rest;

import de.schrader.spring.boot.demo.dto.PersonDto;
import de.schrader.spring.boot.demo.mapper.PersonMapper;
import de.schrader.spring.boot.demo.model.Person;
import de.schrader.spring.boot.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
public class PersonRestControllerImpl implements PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestControllerImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personService
                .getAllPersons()
                .stream()
                .map(PersonMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getPerson(@PathVariable String name) {
        return personService
                .getPerson(name)
                .map(PersonMapper.INSTANCE::toDto)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.INSTANCE.toEntity(personDto);
        Person person_ = personService.createPerson(person);
        return PersonMapper.INSTANCE.toDto(person_);
    }

    @Override
    public PersonDto updatePerson(String name, PersonDto personDto) {
        Person person = PersonMapper.INSTANCE.toEntity(personDto);
        Person person_ = personService.updatePerson(person);
        return PersonMapper.INSTANCE.toDto(person_);
    }

    @Override
    public void deletePerson(String name) {
        personService.deletePerson(name);
    }
}

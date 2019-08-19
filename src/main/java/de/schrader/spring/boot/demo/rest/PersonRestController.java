package de.schrader.spring.boot.demo.rest;

import de.schrader.spring.boot.demo.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/persons")
public interface PersonRestController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<PersonDto> getAllPersons();

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    PersonDto getPerson(@PathVariable String name);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    PersonDto createPerson(@RequestBody PersonDto personDto);

    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    PersonDto updatePerson(@PathVariable String name, @RequestBody PersonDto personDto);

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePerson(@PathVariable String name);
}

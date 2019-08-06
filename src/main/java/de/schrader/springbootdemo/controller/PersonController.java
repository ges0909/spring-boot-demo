package de.schrader.springbootdemo.controller;

import de.schrader.springbootdemo.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface PersonController {

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Person getPerson(@PathVariable String name);
}

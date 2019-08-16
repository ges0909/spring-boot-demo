package de.schrader.spring.boot.demo.rest;

import de.schrader.spring.boot.demo.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public interface PersonController {

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    PersonDto getPerson(@PathVariable String name);

}

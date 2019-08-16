package de.schrader.spring.boot.demo.repo;

import de.schrader.spring.boot.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByName(String name);
}

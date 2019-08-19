package de.schrader.spring.boot.demo.repo;

import de.schrader.spring.boot.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByName(String name);

    void deleteByName(String name);
}

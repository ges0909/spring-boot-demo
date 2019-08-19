package de.schrader.spring.boot.demo;

import de.schrader.spring.boot.demo.model.Person;
import de.schrader.spring.boot.demo.repo.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
// @DataJpaTest:
// - configures H2 as in-memory database
// - sets Hibernate, Spring Data, and the DataSource
// - performs an @EntityScan
// - turns on SQL logging
class ApplicationJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    private Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = TestPerson.of("Vinz", 20);
    }

    @Test
    void givenAPerson_whenPersonIsSaved_thenPersonIsReturned() {
        Person savedPerson = personRepository.save(testPerson);
        assertPerson(savedPerson, testPerson);
    }

    @Test
    void givenAnEmptyDatabase_whenPersonIsSearchedByName_thenNothingIsReturned() {
        Optional<Person> foundPerson = personRepository.findByName(testPerson.getName());
        assertThat(foundPerson).isNotPresent();
    }

    @Test
    void givenAPersistedPerson_whenPersonIsSearchedByName_thenPersonIsReturned() {
        persist(testPerson);
        Optional<Person> foundPerson = personRepository.findByName(testPerson.getName());
        assertThat(foundPerson).isPresent();
        assertPerson(foundPerson.get(), testPerson);
    }

    @Test
    void givenAPersistedPerson_whenPersonIsUpdated_thenUpdatedPersonIsReturned() {
        persist(testPerson);
        testPerson.setAge(30);
        Person updatedPerson = personRepository.save(testPerson);
        assertPerson(updatedPerson, testPerson);
    }

    @Test
    void givenAPersistedPerson_whenPersonIsDeleted_thenPersonIsNotFoundByName() {
        persist(testPerson);
        personRepository.delete(testPerson);
        Optional<Person> person = personRepository.findByName(testPerson.getName());
        assertThat(person).isNotPresent();
    }

    @Test
    void givenAnEmptyDatabase_whenPersonIsDeleted_thenNothingIsReturned() {
        personRepository.delete(testPerson);
        Optional<Person> person = personRepository.findByName(testPerson.getName());
        assertThat(person).isNotPresent();
    }

    private void persist(Person person) {
        entityManager.persist(person);
        entityManager.flush();
    }

    private void assertPerson(Person actual, Person expected) {
        assertThat(actual)
                .isInstanceOf(Person.class)
                .hasFieldOrProperty("id")
                .hasFieldOrProperty("createdAt")
                .hasFieldOrProperty("updatedAt")
                .hasFieldOrPropertyWithValue("name", expected.getName())
                .hasFieldOrPropertyWithValue("age", expected.getAge());
    }
}

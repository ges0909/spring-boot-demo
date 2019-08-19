package de.schrader.spring.boot.demo;

import de.schrader.spring.boot.demo.model.Person;
import de.schrader.spring.boot.demo.repo.PersonRepository;
import de.schrader.spring.boot.demo.service.PersonService;
import de.schrader.spring.boot.demo.service.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ApplicationServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    private Person testPerson = TestPerson.of("Vinz", 20);

    @BeforeEach
    void setUp() {
        when(personRepository.findByName(testPerson.getName()))
                .thenReturn(Optional.of(testPerson));
    }

    @Test
    void whenValidName_thenPersonShouldBeFound() {
        Optional<Person> foundPerson = personService.getPerson(testPerson.getName());
        assertThat(foundPerson)
                .isPresent()
                .get()
                .isInstanceOf(Person.class)
                .hasFieldOrPropertyWithValue("name", testPerson.getName())
                .hasFieldOrPropertyWithValue("age", testPerson.getAge());
    }

    @TestConfiguration
    static class PersonServiceImplTestContextConfiguration {
        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }
}

package de.schrader.spring.boot.demo;

import de.schrader.spring.boot.demo.model.Person;
import de.schrader.spring.boot.demo.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    private Person testPerson;

    @BeforeEach
    void setUp() {
        testPerson = TestPerson.of("Vinz", 20);
        when(personService.getPerson(testPerson.getName()))
                .thenReturn(Optional.of(testPerson));
    }

    @Test
    void givenPerson_whenGetPerson_thenReturnJsonObject() throws Exception {
        mvc.perform(get("/api/persons/" + testPerson.getName()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(testPerson.getName())));
    }
}

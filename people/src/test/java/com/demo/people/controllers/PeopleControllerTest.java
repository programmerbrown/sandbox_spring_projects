package com.demo.people.controllers;

import com.demo.people.repositories.PeopleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.*;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class PeopleControllerTest {

    @Autowired
    PeopleController peopleController;

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldReturnAListOfPeople() throws Exception {

        mockMvc.perform(get("/people?page=0&limit=10"))
                .andExpect(status().isOk())
                .andExpect(view().name("people"))
                .andExpect(content().string(containsString("People Tracker")))
                .andExpect(content().string(containsString("View Details")))
                .andExpect(content().string(containsString("Create a Person")))
                .andExpect(content().string(containsString("/people/10")))
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attribute("page", hasProperty("content", hasSize(10))));

        mockMvc.perform(get("/people?page=0&limit=20"))
                .andExpect(status().isOk())
                .andExpect(view().name("people"))
                .andExpect(content().string(containsString("People Tracker")))
                .andExpect(content().string(containsString("View Details")))
                .andExpect(content().string(containsString("Create a Person")))
                .andExpect(content().string(containsString("/people/20")))
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attribute("page", hasProperty("content", hasSize(20))));
    }

    @Test
    public void shouldReturnASinglePerson() throws Exception {

        mockMvc.perform(get("/people/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("person"))
                .andExpect(content().string(containsString("People Tracker")))
                .andExpect(content().string(containsString("Back")))
                .andExpect(model().attributeExists("person"));
    }

    @Test
    public void shouldReturnAFormToCreateAPersonRecord() throws Exception {

        mockMvc.perform(get("/people/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("new"))
                .andExpect(content().string(containsString("Create a Person Record")))
                .andExpect(content().string(containsString("Cancel")))
                .andExpect(content().string(containsString("Create Person")));
    }

    @Test
    public void shouldCreatePersonRecord() throws Exception {

        assertEquals(26L, peopleRepository.count());


        mockMvc.perform(post("/people")
                .contentType(APPLICATION_FORM_URLENCODED)
                .param("firstName", "Tasha")
                .param("middleName", "James")
                .param("lastName", "Jones"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        assertEquals(27L, peopleRepository.count());
    }

    @Test
    public void shouldReturnUpdateFormForPersonRecord() throws Exception {

        mockMvc.perform(get("/people/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"))
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attribute("person", hasProperty("peopleId", equalTo(1L))))
                .andExpect(model().attribute("person", hasProperty("firstName", equalTo("Nick"))));

    }

    @Test
    public void shouldUpdatePersonRecord() throws Exception {

        mockMvc.perform(get("/people/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attribute("person", hasProperty("peopleId", equalTo(1L))))
                .andExpect(model().attribute("person", hasProperty("firstName", equalTo("Nick"))));

        mockMvc.perform(put("/people/1")
                .contentType(APPLICATION_FORM_URLENCODED)
                .param("peopleId", "1")
                .param("firstName", "James")
                .param("middleName", "George")
                .param("lastName", "Brown")
                .param("birthday", "11-9-1980")
                .param("favoriteColor", "BLACK")
                .param("birthLocation", "AUGUSTA,GA")
                .param("motherName", "JACQUELINE BROWN")
                .param("fatherName", "KENNETH BROWN")
                .param("maritalStatus", "SINGLE")
                .param("gender", "MALE")
                .param("isVegetarianOrVegan", "NO"))
                .andExpect(status().is2xxSuccessful());

        mockMvc.perform(get("/people/1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attribute("person", hasProperty("peopleId", equalTo(1L))))
                .andExpect(model().attribute("person", hasProperty("firstName", equalTo("James"))));
    }

    @Test
    public void shouldDeletePersonRecord() throws Exception {

        assertEquals(26L, peopleRepository.count());

        mockMvc.perform(delete("/people/2"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        assertEquals(25L, peopleRepository.count());
    }
}
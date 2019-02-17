package com.demo.people.controllers;

import com.demo.people.repositories.PeopleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
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
    public void shouldReturnPeoplePage() throws Exception {
        mockMvc.perform(get("/people"))
                .andExpect(status().isOk())
                .andExpect(view().name("people"))
                .andExpect(content().string(containsString("People Tracker")))
                .andExpect(content().string(containsString("View Details")))
                .andExpect(content().string(containsString("Create a Person")))
                .andExpect(content().string(containsString("/people/1")))
                .andExpect(model().attributeExists("people"))
                .andExpect(model().attribute("people", hasSize(1)));
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
        mockMvc.perform(post("/people")
                .contentType(APPLICATION_FORM_URLENCODED)
                .param("firstName", "Tasha")
                .param("middleName", "James")
                .param("lastName", "Jones"))
                .andExpect(status().is3xxRedirection())
                .andReturn();

        mockMvc.perform(get("/people"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("people"))
                .andExpect(model().attribute("people", hasSize(2)));
    }
}
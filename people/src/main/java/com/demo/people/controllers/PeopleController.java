package com.demo.people.controllers;

import com.demo.people.models.Person;
import com.demo.people.repositories.PeopleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {

    private PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {

        Iterable<Person> people = peopleRepository.findAll();

        model.addAttribute("people", people);

        return "home";
    }
}

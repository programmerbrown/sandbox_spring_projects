package com.demo.people.controllers;

import com.demo.people.repositories.PeopleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping
    public String getListOfAllPeople(Model model) {
        model.addAttribute("people", peopleRepository.findAll());

        return "people";
    }

    @GetMapping("/{id}")
    public String getASinglePerson(@PathVariable long id, Model model) {
        model.addAttribute("person", peopleRepository.findById(id).get());

        return "person";
    }
}

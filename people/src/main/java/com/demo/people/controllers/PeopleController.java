package com.demo.people.controllers;

import com.demo.people.models.Person;
import com.demo.people.repositories.PeopleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public String createAPersonRecord(@ModelAttribute Person person) {
        Person savedPerson = peopleRepository.save(person);

        return "redirect:/people/" + savedPerson.getPeopleId();
    }

    @GetMapping("/{id}")
    public String getASinglePerson(@PathVariable long id, Model model) {
        model.addAttribute("person", peopleRepository.findById(id).get());

        return "person";
    }

    @PutMapping("/{id}")
    public String updateSinglePerson(@PathVariable long id, @ModelAttribute Person person, Model model) {
        model.addAttribute("person", peopleRepository.save(person));

        return "person";
    }

    @GetMapping("/new")
    public String getCreateForm(Model model) {
        model.addAttribute("person", new Person());

        return "new";
    }

    @GetMapping("/{id}/edit")
    public String getEditForm(@PathVariable long id, Model model) {
        model.addAttribute("person", peopleRepository.findById(id).get());

        return "edit";
    }

    @DeleteMapping("/{id}")
    public String deletePersonRecord(@PathVariable long id) {
        peopleRepository.deleteById(id);

        return "redirect:/people";
    }

}

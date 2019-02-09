package com.demo.people.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeopleController {


    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }
}


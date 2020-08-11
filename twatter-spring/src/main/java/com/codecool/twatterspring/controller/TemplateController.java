package com.codecool.twatterspring.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dev")
@Profile("development")
@CrossOrigin(origins = "*")
public class TemplateController {

    @GetMapping
    public String indexPage() {
        return "index";
    }

    @GetMapping("login")
    public String loginPage() {
        return "login";
    }
}

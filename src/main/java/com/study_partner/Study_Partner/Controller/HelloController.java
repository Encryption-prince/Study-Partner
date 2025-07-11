package com.study_partner.Study_Partner.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
    @GetMapping({"/hello","/"})
    public String sayHello() {
        return "Hello, World!";
    }
}

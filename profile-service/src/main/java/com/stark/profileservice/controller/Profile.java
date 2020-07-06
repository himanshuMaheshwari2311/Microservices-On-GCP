package com.stark.profileservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Profile {

    @GetMapping(value="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}

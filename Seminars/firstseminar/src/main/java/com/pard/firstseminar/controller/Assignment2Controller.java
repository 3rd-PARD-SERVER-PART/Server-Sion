package com.pard.firstseminar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Assignment2Controller {
    @RequestMapping("/assignment2")
    public String Assignment2(
            @RequestParam(defaultValue = "guest") String name,
            @RequestParam(defaultValue = "20") Integer age,
            @RequestParam(defaultValue = "Unknown") String major,
            @RequestParam(defaultValue = "None") String hobby){
        return "Name: " + name + ", Age: " + age + ", Major: " + major + ", Hobby: " + hobby;
    }
}

package com.kth.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/doSomething")
    public String doSomething() {
        service.doSomething();
        return "Method doSomething() has been executed!";
    }
}

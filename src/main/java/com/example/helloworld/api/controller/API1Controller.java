package com.example.helloworld.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class API1Controller {
    @GetMapping("/muzakki")
    public Integer muzakki(@RequestParam(name = "number") Integer number) {
        return number*number;
    }
}

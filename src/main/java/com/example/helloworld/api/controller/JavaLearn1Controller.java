package com.example.helloworld.api.controller;

import com.example.helloworld.api.service.JavaLearn1Service;
import com.example.helloworld.api.service2.JavaLearn2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaLearn1Controller {
    @Autowired
    private JavaLearn1Service javaLearn1Service;

    @Autowired
    private JavaLearn2Service javaLearn2Service;


    @GetMapping("/square/number")
    public Integer squareFromNumber(
            @RequestParam(name = "number") Integer number
    ) {
        return javaLearn1Service.square(number);
    }
}

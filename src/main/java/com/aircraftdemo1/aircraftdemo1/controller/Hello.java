package com.aircraftdemo1.aircraftdemo1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/say")
public class Hello {


    @GetMapping("/hello")
    public String hello(){
        return "Helooooo";
    }
}

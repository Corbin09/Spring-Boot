package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {
    @GetMapping("hello")
    public String getHelloWorld() {
        return "HelloSpring1!";
    }
    
}

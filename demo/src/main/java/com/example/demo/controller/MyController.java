package com.example.demo.controller;

import com.example.demo.service.ConstructorInjectedService;
import com.example.demo.service.FieldInjectedService;
import com.example.demo.service.SetterInjectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final ConstructorInjectedService constructorInjectedService;
    private final SetterInjectedService setterInjectedService;
    private final FieldInjectedService fieldInjectedService;

    @Autowired
    public MyController(ConstructorInjectedService constructorInjectedService,
                        SetterInjectedService setterInjectedService,
                        FieldInjectedService fieldInjectedService) {
        this.constructorInjectedService = constructorInjectedService;
        this.setterInjectedService = setterInjectedService;
        this.fieldInjectedService = fieldInjectedService;
    }

    @GetMapping("/constructor")
    public String constructorInjection() {
        return constructorInjectedService.serve();
    }

    @GetMapping("/setter")
    public String setterInjection() {
        return setterInjectedService.serve();
    }

    @GetMapping("/field")
    public String fieldInjection() {
        return fieldInjectedService.serve();
    }
}

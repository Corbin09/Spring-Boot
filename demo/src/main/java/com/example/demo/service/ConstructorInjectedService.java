package com.example.demo.service;

import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedService {

    private final MyRepository myRepository;

    @Autowired
    public ConstructorInjectedService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public String serve() {
        return "Constructor: " + myRepository.getData();
    }
}

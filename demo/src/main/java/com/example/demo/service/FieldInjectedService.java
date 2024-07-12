package com.example.demo.service;

import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldInjectedService {

    @Autowired
    private MyRepository myRepository;

    public String serve() {
        return "Field: " + myRepository.getData();
    }
}

package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public String getData() {
        return "Data"; //data from repository
    }
}

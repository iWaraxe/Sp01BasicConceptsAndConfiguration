// File: MyService.java
package com.coherentsolutions.spring.school.section33annotation.services;

import com.coherentsolutions.spring.school.section33annotation.repositories.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    // Other methods
    public void performAction() {
        repository.save();
    }
}

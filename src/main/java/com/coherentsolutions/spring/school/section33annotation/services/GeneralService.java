// File: Service.java
package com.coherentsolutions.spring.school.section33annotation.services;

import com.coherentsolutions.spring.school.section33annotation.repositories.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneralService {
    private final GeneralRepository repository;

    @Autowired
    public GeneralService(GeneralRepository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

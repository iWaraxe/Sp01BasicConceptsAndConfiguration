package com.coherentsolutions.spring.school.section21coreconcepts.springflavored.service;

import com.coherentsolutions.spring.school.section21coreconcepts.springflavored.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }

    public static void main(String[] args) {
        // This main method won't run the Spring context, it's here for structure.
        System.out.println("Run this class within a Spring ApplicationContext.");
    }
}

package com.coherentsolutions.spring.school.section21coreconcepts.springflavored.repository;

import org.springframework.stereotype.Component;

@Component
public class Repository {
    public void save() {
        System.out.println("Data saved!");
    }
}

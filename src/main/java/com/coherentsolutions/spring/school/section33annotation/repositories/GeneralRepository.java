// File: BookRepository.java
package com.coherentsolutions.spring.school.section33annotation.repositories;

import org.springframework.stereotype.Component;

@Component
public class GeneralRepository implements Repository {
    public void save() {
        System.out.println("Data saved!");
    }
}

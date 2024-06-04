// File: Service.java
package com.coherentsolutions.spring.school.section22ApplicationContext.ex02annotationbased;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    private DataRepository repository;

    public void setRepository(DataRepository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

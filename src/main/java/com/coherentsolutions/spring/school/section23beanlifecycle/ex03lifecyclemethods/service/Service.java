// File: Service.java (Lifecycle Demonstration)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.service;

import com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    private Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

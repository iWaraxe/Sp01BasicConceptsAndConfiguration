// File: BookRepository.java (Lifecycle Demonstration)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Repository {

    @PostConstruct
    public void init() {
        System.out.println("Repository Bean is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Repository Bean will destroy now.");
    }

    public void save() {
        System.out.println("Data saved!");
    }
}

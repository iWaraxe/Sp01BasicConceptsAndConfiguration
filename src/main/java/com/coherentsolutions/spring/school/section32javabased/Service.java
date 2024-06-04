// File: Service.java
package com.coherentsolutions.spring.school.section32javabased;

public class Service {
    private Repository repository;

    public Service() {
    }

    // Constructor for Constructor Injection
    public Service(Repository repository) {
        this.repository = repository;
    }

    // Setter for Setter Injection
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

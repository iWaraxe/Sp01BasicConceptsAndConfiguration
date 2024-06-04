// File: Service.java
package com.coherentsolutions.spring.school.section31xmlbased;

public class Service {
    private Repository repository;

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

// File: Service.java
package com.coherentsolutions.spring.school.section22ApplicationContext.ex01xmlbased;

public class Service {
    private Repository repository;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

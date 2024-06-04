package com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.ex01IoC;

import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.repository.Repository;

public class ServiceWithIoC {
    private Repository repository;

    public ServiceWithIoC(Repository repository) { // Dependency is injected
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }

    public static void main(String[] args) {
        Repository repository = new Repository();
        ServiceWithIoC service = new ServiceWithIoC(repository);
        service.performAction();
    }
}

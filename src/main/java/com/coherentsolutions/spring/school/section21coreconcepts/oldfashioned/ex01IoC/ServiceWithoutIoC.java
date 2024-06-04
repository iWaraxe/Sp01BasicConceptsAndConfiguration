package com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.ex01IoC;

import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.repository.Repository;

public class ServiceWithoutIoC {
    private Repository repository;

    public ServiceWithoutIoC() {
        this.repository = new Repository(); // Tight coupling: Service creates its own Repository
    }

    public void performAction() {
        repository.save();
    }

    public static void main(String[] args) {
        ServiceWithoutIoC service = new ServiceWithoutIoC();
        service.performAction();
    }
}

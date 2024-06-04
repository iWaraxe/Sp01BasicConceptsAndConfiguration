package com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.service;

import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.repository.BookRepository;

public class ConstructorInjectedService {
    private final BookRepository bookRepository;

    public ConstructorInjectedService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("Executing service with constructor injection.");
        bookRepository.save();
    }
}
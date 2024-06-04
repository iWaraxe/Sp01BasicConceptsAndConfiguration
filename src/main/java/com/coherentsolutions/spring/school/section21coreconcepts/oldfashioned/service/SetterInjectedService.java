package com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.service;

import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.repository.BookRepository;

public class SetterInjectedService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute() {
        System.out.println("Executing service with setter injection.");
        bookRepository.save();
    }
}

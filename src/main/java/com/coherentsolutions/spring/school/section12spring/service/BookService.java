package com.coherentsolutions.spring.school.section12spring.service;

import com.coherentsolutions.spring.school.section12spring.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void processBook() {
        System.out.println("Processing book...");
        bookRepository.saveBook();
    }
}

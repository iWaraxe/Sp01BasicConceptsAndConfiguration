package com.coherentsolutions.spring.school.section12spring;

import com.coherentsolutions.spring.school.section12spring.repository.BookRepository;
import com.coherentsolutions.spring.school.section12spring.service.BookService;

public class MainJava {
    public static void main(String[] args) {
        // Manually creating an instance of BookRepository
        BookRepository bookRepository = new BookRepository();

        // Manually creating an instance of BookService
        BookService bookService = new BookService();

        // Manually injecting the BookRepository into the BookService
        bookService.setBookRepository(bookRepository);

        // Using the bookService to process the book
        bookService.processBook();

        // Print a message indicating that the application is running without Spring
        System.out.println("This application is running without Spring IoC container.");
    }
}

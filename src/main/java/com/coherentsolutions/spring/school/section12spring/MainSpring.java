package com.coherentsolutions.spring.school.section12spring;

import com.coherentsolutions.spring.school.section12spring.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        // Loading the Spring XML configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieving the bookService bean from the Spring IoC container
        BookService bookService = context.getBean("bookService12", BookService.class);

        // Using the bookService bean
        bookService.processBook();

        // Closing the context
        context.close();

        // Print a message indicating that the application is running with Spring
        System.out.println("This application is running with Spring IoC container.");
    }
}

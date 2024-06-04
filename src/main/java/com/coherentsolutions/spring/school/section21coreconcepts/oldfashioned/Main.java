package com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned;

import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.repository.BookRepository;
import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.service.ConstructorInjectedService;
import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.service.FieldInjectedService;
import com.coherentsolutions.spring.school.section21coreconcepts.oldfashioned.service.SetterInjectedService;

public class Main {
    public static void main(String[] args) {

        BookRepository repository = new BookRepository();

        // Constructor Injection
        ConstructorInjectedService constructorService = new ConstructorInjectedService(repository);
        constructorService.execute();

        // Setter Injection
        SetterInjectedService setterService = new SetterInjectedService();
        setterService.setBookRepository(repository);
        setterService.execute();

        // Field Injection
        FieldInjectedService fieldService = new FieldInjectedService();
        fieldService.bookRepository = repository; // Direct field access (not recommended outside of Spring context)
        fieldService.execute();

        // Field Injection: Using Spring to manage field injection
        // The below direct assignment simulates what Spring does under the hood for field injection
        // In a fully integrated Spring application, obtaining the bean from the context would demonstrate this more naturally
        //FieldInjectedService fieldService = context.getBean(FieldInjectedService.class);
        // No manual assignment is necessary as Spring handles it
        //fieldService.execute();
    }
}
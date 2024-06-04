package com.coherentsolutions.spring.school.section22ApplicationContext.ex01xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // Create the application context from the configuration class
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the service bean from the context
        Service service = context.getBean(Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}

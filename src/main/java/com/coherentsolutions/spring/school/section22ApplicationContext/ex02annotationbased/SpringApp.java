// File: SpringApp.java
package com.coherentsolutions.spring.school.section22ApplicationContext.ex02annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // Create the application context from the configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the service bean from the context
        DataService service = context.getBean(DataService.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}

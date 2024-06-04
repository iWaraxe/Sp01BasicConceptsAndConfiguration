// File: SpringApp.java
package com.coherentsolutions.spring.school.section33annotation;

import com.coherentsolutions.spring.school.section33annotation.ex01.AppConfigDemo;
import com.coherentsolutions.spring.school.section33annotation.services.GeneralService;
import com.coherentsolutions.spring.school.section33annotation.services.MyServiceWithQualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // Create the application context from the configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigDemo.class);

        // Retrieve the service bean from the context
        MyServiceWithQualifier service = context.getBean(MyServiceWithQualifier.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}

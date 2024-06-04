// File: SpringApp.java (ApplicationContext Initialization and Bean Access)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods;

import com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // Create the application context from the configuration class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigDemo.class);

        // Retrieve the service bean from the context
        Service service = context.getBean(Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        context.close();
    }
}

// File: SpringApp.java
package com.coherentsolutions.spring.school.section31xmlbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // Load the application context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the service bean from the context
        Service service = context.getBean("service", Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}

// File: AppConfig.java
package com.coherentsolutions.spring.school.section22ApplicationContext.ex02annotationbased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataRepository repository() {
        return new DataRepository();
    }

    @Bean
    public DataService service() {
        DataService service = new DataService();
        service.setRepository(repository());
        return service;
    }
}

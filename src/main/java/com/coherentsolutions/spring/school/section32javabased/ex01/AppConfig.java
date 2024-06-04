// File: AppConfig.java
package com.coherentsolutions.spring.school.section32javabased.ex01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyClass myBean() {
        return new MyClass();
    }
}

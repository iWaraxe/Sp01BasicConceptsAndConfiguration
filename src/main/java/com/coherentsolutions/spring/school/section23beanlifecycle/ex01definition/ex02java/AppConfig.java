// File: AppConfig.java (Java-based Configuration)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex01definition.ex02java;

import com.coherentsolutions.spring.school.section23beanlifecycle.ex01definition.ex01xml.MyClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyClass myBean() {
        return new MyClass();
    }
}

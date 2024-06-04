// File: AppConfigConstructorInjection.java
package com.coherentsolutions.spring.school.section32javabased.ex02;

import com.coherentsolutions.spring.school.section32javabased.Repository;
import com.coherentsolutions.spring.school.section32javabased.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigConstructorInjection {

    @Bean
    public Repository repository() {
        return new Repository();
    }

    @Bean
    public Service service() {
        return new Service(repository());
    }
}

// File: AppConfigSetterInjection.java
package com.coherentsolutions.spring.school.section32javabased.ex03;

import com.coherentsolutions.spring.school.section32javabased.Repository;
import com.coherentsolutions.spring.school.section32javabased.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSetterInjection {

    @Bean
    public Repository repository() {
        return new Repository();
    }

    @Bean
    public Service service() {
        Service service = new Service();
        service.setRepository(repository());
        return service;
    }
}

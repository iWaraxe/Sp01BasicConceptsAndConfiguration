// File: MyClassScope.java (Bean Scopes)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex02scopes;

import com.coherentsolutions.spring.school.section23beanlifecycle.ex01definition.ex03annotation.MyClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyClassScope {

    @Bean
    @Scope("singleton")
    public MyClass mySingletonBean() {
        return new MyClass();
    }

    @Bean
    @Scope("prototype")
    public MyClass myPrototypeBean() {
        return new MyClass();
    }

    @Bean
    @Scope("request")
    public MyClass myRequestBean() {
        return new MyClass();
    }

    @Bean
    @Scope("session")
    public MyClass mySessionBean() {
        return new MyClass();
    }

    @Bean
    @Scope("globalSession")
    public MyClass myGlobalSessionBean() {
        return new MyClass();
    }
}

// File: MyClassLifecycle.java (Lifecycle Annotations)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.ex01postconstruct_predestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyClassLifecycle {

    @PostConstruct
    public void init() {
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}

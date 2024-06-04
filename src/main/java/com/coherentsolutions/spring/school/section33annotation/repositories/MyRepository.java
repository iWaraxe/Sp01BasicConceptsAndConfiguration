// File: MyRepository.java
package com.coherentsolutions.spring.school.section33annotation.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mySpecificRepository")
public class MyRepository implements Repository {
    public void save() {
        System.out.println("Data saved!");
    }
}

// File: MyServiceWithQualifier.java
package com.coherentsolutions.spring.school.section33annotation.services;

import com.coherentsolutions.spring.school.section33annotation.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyServiceWithQualifier {

    @Autowired
    @Qualifier("mySpecificRepository")
    private Repository repository;

    // Other methods
    public void performAction() {
        repository.save();
    }
}

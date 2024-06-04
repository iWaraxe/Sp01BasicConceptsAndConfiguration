package com.coherentsolutions.spring.school.section22ApplicationContext.ex02annotationbased;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {
    public void save() {
        System.out.println("Data saved!");
    }
}
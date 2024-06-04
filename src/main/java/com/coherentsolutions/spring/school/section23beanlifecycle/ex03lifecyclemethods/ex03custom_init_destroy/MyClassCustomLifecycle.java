// File: MyClassCustomLifecycle.java (Custom Init and Destroy Methods)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.ex03custom_init_destroy;

public class MyClassCustomLifecycle {

    public void customInit() {
        System.out.println("Bean is going through customInit.");
    }

    public void customDestroy() {
        System.out.println("Bean will destroy now via customDestroy.");
    }
}

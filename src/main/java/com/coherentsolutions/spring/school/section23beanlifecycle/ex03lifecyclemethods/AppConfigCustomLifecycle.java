
// File: AppConfigCustomLifecycle.java (Configuration Class with Custom Init and Destroy Methods)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods;

import com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.ex03custom_init_destroy.MyClassCustomLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigCustomLifecycle {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public MyClassCustomLifecycle myBean() {
        return new MyClassCustomLifecycle();
    }
}

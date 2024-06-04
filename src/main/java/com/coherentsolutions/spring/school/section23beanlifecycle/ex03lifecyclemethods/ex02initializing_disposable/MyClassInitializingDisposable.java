// File: MyClassInitializingDisposable.java (InitializingBean and DisposableBean Interfaces)
package com.coherentsolutions.spring.school.section23beanlifecycle.ex03lifecyclemethods.ex02initializing_disposable;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class MyClassInitializingDisposable implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean is going through afterPropertiesSet.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean will destroy now.");
    }
}

# 2. Core Concepts
## 2.1. Inversion of Control (IoC) and Dependency Injection (DI)
- **IoC:** A design principle where the control of object creation and lifecycle management is transferred to a container or framework.
- **DI:** A pattern used to implement IoC, allowing dependencies to be injected into objects at runtime.

### 2.1.0 Introduction
And now, we are going to dive into two fundamental concepts of the Spring Framework: Inversion of Control (IoC) and Dependency Injection (DI). These concepts are crucial for understanding how Spring helps us write modular, maintainable, and testable code.

---

### 2.1.1. Inversion of Control (IoC)

#### Definition

Inversion of Control, or IoC, is a design principle where the control of object creation and lifecycle management is transferred to a container or framework. Instead of having the application code control the flow of the program, the framework does. This helps in achieving loose coupling and better manageability of code by decoupling the object's creation from its usage.

#### Example Without IoC

Let's first look at how things work without IoC. Imagine we have a `Service` class that depends on a `Repository` class. In a typical setup without IoC, the `Service` class is responsible for creating an instance of the `Repository` class.
```java
class Repository {
public void save() {
System.out.println("Data saved!");
}
}

class ServiceWithoutIoC {
private Repository repository;

    public ServiceWithoutIoC() {
        this.repository = new Repository(); // Tight coupling: Service creates its own Repository
    }

    public void performAction() {
        repository.save();
    }
}
```
In this example, the `ServiceWithoutIoC` class directly creates an instance of the `Repository` class, leading to tight coupling.

#### Example With IoC

Now, let's see how we can refactor this code using the IoC principle. With IoC, the control of creating the `Repository` instance is moved out of the `Service` class.
```java
class Repository {
public void save() {
System.out.println("Data saved!");
}
}

class ServiceWithIoC {
private Repository repository;

    public ServiceWithIoC(Repository repository) { // Dependency is injected
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```
In this example, the `ServiceWithIoC` class does not create an instance of `Repository` itself. Instead, the `Repository` instance is provided to it, making the code more flexible and easier to test.

---

## 2.2. Dependency Injection (DI)

#### Definition

Dependency Injection, or DI, is a pattern used to implement IoC. It allows dependencies to be injected into objects at runtime. DI can be achieved through constructor injection, setter injection, or field injection.

#### Constructor Injection

Constructor Injection is when the dependency is provided through the class constructor.
```java
class ServiceWithConstructorInjection {
private Repository repository;

    public ServiceWithConstructorInjection(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

In this example, the `Repository` instance is injected into the `ServiceWithConstructorInjection` class through its constructor.

#### Setter Injection

Setter Injection is when the dependency is provided through a setter method.

class ServiceWithSetterInjection {
private Repository repository;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```
In this example, the `Repository` instance is injected into the `ServiceWithSetterInjection` class through a setter method.

#### Field Injection

Field Injection is when the dependency is injected directly into a field. This is commonly done using annotations.
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ServiceWithFieldInjection {
@Autowired
private Repository repository;

    public void performAction() {
        repository.save();
    }
}
```

In this example, the `Repository` instance is injected directly into the `ServiceWithFieldInjection` class's field using the `@Autowired` annotation.

---

### 2.1.3. Live Coding Session

Now, let's see these concepts in action using the Spring Framework. We'll create a simple Spring application that demonstrates Dependency Injection.

#### Setting Up Spring

First, we need to set up our Spring application. We'll use a configuration class to define our beans.
```java
package com.example.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Define a simple Repository class
@Component
class Repository {
public void save() {
System.out.println("Data saved!");
}
}

// Define a Service class that depends on Repository
@Component
class Service {
private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}

// Configuration class
@Configuration
@ComponentScan(basePackages = "com.example.springdemo")
class AppConfig {
}

// Main class to run the application
public class SpringApp {
public static void main(String[] args) {
// Create the application context from the configuration class
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the service bean from the context
        Service service = context.getBean(Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
```
#### Explanation

In this example, we've defined a simple `Repository` class and a `Service` class that depends on `Repository`. Using Spring's Dependency Injection, we let Spring manage the creation and injection of the `Repository` instance into the `Service` class.

- The `@Component` annotation marks the classes as Spring-managed components.
- The `@Autowired` annotation on the constructor of `Service` tells Spring to inject the `Repository` dependency when creating a `Service` instance.
- The `@Configuration` and `@ComponentScan` annotations in the `AppConfig` class set up the Spring context and specify which packages to scan for components.

By using Spring's IoC container, we achieve loose coupling, better testability, and more maintainable code.

---

### 2.1.4. Conclusion

We've covered the key concepts of Inversion of Control (IoC) and Dependency Injection (DI) and how they are implemented in the Spring Framework. By transferring control of object creation and lifecycle management to the Spring container, we achieve a more modular and maintainable codebase. Dependency Injection allows us to inject dependencies at runtime, further enhancing the flexibility and testability of our applications.

---

## Homework

1. Create a simple Spring application with a `Service` and a `Repository` class.
2. Implement Constructor Injection and Setter Injection for the dependencies.
3. Experiment with the different scopes of beans (Singleton, Prototype) and observe the behavior.

---

## 2.2 Container: ApplicationContext
### 2.2.0 Introduction

Now, we are going to explore the role of the IoC Container in the Spring Framework, specifically focusing on `ApplicationContext`. We will cover the purpose and features of `ApplicationContext`, the difference between `BeanFactory` and `ApplicationContext`, and we will conclude with a demonstration on creating and configuring `ApplicationContext`.

---

### 2.2.1 Role of ApplicationContext in Spring

#### Definition

`ApplicationContext` is the central interface to the Spring IoC container. It is responsible for instantiating, configuring, and assembling the beans. In simpler terms, it manages the lifecycle and dependencies of the beans in a Spring application.

#### Features

`ApplicationContext` provides several advanced features that make it more powerful than the basic `BeanFactory`:

1. **Bean Lifecycle Management:** It manages the complete lifecycle of beans, including their creation, initialization, and destruction.
2. **Internationalization (i18n):** It supports internationalization by providing access to resource bundles.
3. **Event Propagation:** It provides a mechanism for event propagation, allowing beans to publish and listen to events.
4. **Declarative Support:** It supports declarative mechanisms for configuration, such as annotations and XML configurations.
5. **Convenient Methods:** It provides several convenient methods for accessing beans, such as `getBean`.

---

### 2.2.2. Difference between BeanFactory and ApplicationContext

#### BeanFactory

`BeanFactory` is the simplest container in the Spring framework that provides the basic IoC functionality. It is responsible for instantiating, configuring, and managing beans. However, it lacks many advanced features provided by `ApplicationContext`.

#### ApplicationContext

`ApplicationContext` is an extension of `BeanFactory` and provides all the features of `BeanFactory` along with additional capabilities:

- **Eager Initialization:** `ApplicationContext` eagerly loads all singleton beans at startup, whereas `BeanFactory` loads beans lazily.
- **Advanced Features:** As mentioned earlier, `ApplicationContext` supports internationalization, event propagation, and declarative configuration.
- **Integration with Spring AOP:** `ApplicationContext` seamlessly integrates with Spring’s Aspect-Oriented Programming (AOP) capabilities.

In summary, while `BeanFactory` is suitable for simple scenarios, `ApplicationContext` is recommended for most enterprise applications due to its rich set of features.

---

### 2.2.3. Demonstration: Creating and Configuring ApplicationContext

Let's now see how to create and configure an `ApplicationContext` in a Spring application. We'll go through the steps of defining beans and accessing them using `ApplicationContext`.

#### Step 1: Define the Bean Classes

First, let's define two simple bean classes: `Repository` and `Service`.

```java
package com.example.springdemo;

public class Repository {
public void save() {
System.out.println("Data saved!");
}
}

public class Service {
private Repository repository;

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```

#### Step 2: Create the Spring Configuration File

Next, we'll create a configuration file using Java-based configuration. This file will define our beans and their dependencies.

```java
package com.example.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

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
```

#### Step 3: Initialize ApplicationContext and Access Beans

Finally, we'll initialize the `ApplicationContext` and access our beans.

```java
package com.example.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
public static void main(String[] args) {
// Create the application context from the configuration class
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the service bean from the context
        Service service = context.getBean(Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}
```

#### Explanation

1. **Define the Bean Classes:** We defined two simple classes, `Repository` and `Service`. The `Service` class depends on the `Repository` class.
2. **Create the Spring Configuration File:** We created a Java-based configuration file, `AppConfig`, using the `@Configuration` and `@Bean` annotations. This file defines the beans and their dependencies.
3. **Initialize ApplicationContext:** In the `SpringApp` class, we initialize the `ApplicationContext` using `AnnotationConfigApplicationContext` and pass our configuration class to it.
4. **Retrieve and Use Beans:** We retrieve the `Service` bean from the context using `context.getBean(Service.class)` and use it to perform an action.

By following these steps, we can see how `ApplicationContext` manages the lifecycle and dependencies of our beans, providing a powerful mechanism for building and managing Spring applications.

---

### 2.2.4 Conclusion

Today, we've explored the role of `ApplicationContext` in the Spring Framework. We've discussed its advanced features, the differences between `BeanFactory` and `ApplicationContext`, and demonstrated how to create and configure `ApplicationContext` in a Spring application.

---


# 2.3. Bean Definition and Lifecycle

## 2.3.0. Introduction

Good morning, everyone! Today, we are going to dive deep into the topic of Bean Definition and Lifecycle in the Spring Framework. This is a crucial part of understanding how Spring manages the objects that form the backbone of our applications. We'll cover how to define beans in Spring, explore the various bean scopes, discuss bean lifecycle methods, and see a demonstration of bean lifecycle management in a Spring application.

---

## 2.3.1. Bean Definition and Lifecycle

### Defining Beans in Spring

Beans are the backbone of a Spring application and are managed by the Spring IoC container. A bean is simply an object that is instantiated, assembled, and managed by a Spring IoC container.

There are multiple ways to define beans in Spring:

1. **XML Configuration**
2. **Java-based Configuration**
3. **Annotation-based Configuration**

### XML Configuration

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.example.MyClass" />

</beans>
```

### Java-based Configuration

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyClass myBean() {
        return new MyClass();
    }
}
```

### Annotation-based Configuration

```java
import org.springframework.stereotype.Component;

@Component
public class MyClass {
// Bean definition
}
```

---

## 2.3.2. Bean Scopes

Bean scope refers to the lifecycle of a bean – how long a bean should be retained in the Spring IoC container. Spring supports several bean scopes:

1. **Singleton**
2. **Prototype**
3. **Request**
4. **Session**
5. **Global Session**

#### Singleton Scope

The singleton scope is the default scope in Spring. A singleton-scoped bean is instantiated once per Spring IoC container and shared across the entire application context.

```java
@Bean
@Scope("singleton")
public MyClass mySingletonBean() {
return new MyClass();
}
```

#### Prototype Scope

A prototype-scoped bean is instantiated every time it is requested from the Spring IoC container.

```java
@Bean
@Scope("prototype")
public MyClass myPrototypeBean() {
return new MyClass();
}
```

#### Request, Session, and Global Session Scopes

These scopes are primarily used in web applications.

- **Request Scope:** A new bean instance is created for each HTTP request.
- **Session Scope:** A new bean instance is created for each HTTP session.
- **Global Session Scope:** Typically used in portlet-based applications to create a global session bean.

```java
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
```

---

## 2.3.3. Bean Lifecycle Methods

Spring provides several ways to manage the lifecycle of beans. These lifecycle methods allow you to perform custom actions during the initialization and destruction of beans.

1. **`@PostConstruct` and `@PreDestroy` Annotations**
2. **InitializingBean and DisposableBean Interfaces**
3. **Custom init-method and destroy-method**

#### `@PostConstruct` and `@PreDestroy` Annotations

```java
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyClass {

    @PostConstruct
    public void init() {
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}
```

#### InitializingBean and DisposableBean Interfaces

```java
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

@Component
public class MyClass implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean is going through afterPropertiesSet.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean will destroy now.");
    }
}
```

#### Custom init-method and destroy-method

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    public MyClass myBean() {
        return new MyClass();
    }
}
```

```java
public class MyClass {

    public void customInit() {
        System.out.println("Bean is going through customInit.");
    }

    public void customDestroy() {
        System.out.println("Bean will destroy now via customDestroy.");
    }
}
```

---

## 2.3.4. Demonstration: Bean Lifecycle Management in a Spring Application

Now, let's put everything together and see how we can manage the bean lifecycle in a Spring application. We'll define beans, specify their scopes, and observe their lifecycle methods in action.

#### Step 1: Define Bean Classes

```java
package com.example.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Repository {

    @PostConstruct
    public void init() {
        System.out.println("Repository Bean is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Repository Bean will destroy now.");
    }

    public void save() {
        System.out.println("Data saved!");
    }
}
```

```java
package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
private Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```

#### Step 2: Create Configuration Class

```java
package com.example.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springdemo")
public class AppConfig {
}
```

#### Step 3: Initialize ApplicationContext and Access Beans

```java
package com.example.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
public static void main(String[] args) {
// Create the application context from the configuration class
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve the service bean from the context
        Service service = context.getBean(Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        context.close();
    }
}
```

### Explanation

1. **Define Bean Classes:** We defined `Repository` and `Service` classes. The `Repository` class has `@PostConstruct` and `@PreDestroy` annotations to define custom initialization and destruction methods.
2. **Create Configuration Class:** We created a configuration class, `AppConfig`, using the `@Configuration` and `@ComponentScan` annotations to scan for Spring components.
3. **Initialize ApplicationContext:** In the `SpringApp` class, we initialize the `ApplicationContext` using `AnnotationConfigApplicationContext` and pass our configuration class to it.
4. **Retrieve and Use Beans:** We retrieve the `Service` bean from the context and use it to perform an action.

By following these steps, we can see how Spring manages the lifecycle of beans, including their creation, initialization, and destruction.

---

## 2.3.5. Conclusion

We've explored the definition and lifecycle of beans in the Spring Framework. We've discussed how to define beans, the different bean scopes, lifecycle methods, and demonstrated bean lifecycle management in a Spring application.

---

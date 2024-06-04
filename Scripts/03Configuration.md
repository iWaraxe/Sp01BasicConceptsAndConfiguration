# 3. Configuration (20 minutes)
# 3.1. XML-based Configuration

## Introduction

And now, we're going to focus on XML-based configuration in the Spring Framework. This method of configuration has been around since the early days of Spring and, while modern Spring applications often use Java-based or annotation-based configurations, understanding XML configuration is crucial for maintaining legacy applications and understanding the foundations of Spring.

We'll cover the structure of an XML configuration file, how to define beans and their dependencies using XML, and then we'll go through an example of configuring a simple Spring application using XML.

---

### 3.1. XML-based Configuration

### Structure of an XML Configuration File

In Spring, the XML configuration file is used to define the beans and their dependencies. The root element of the configuration file is `<beans>`, which contains all the bean definitions. Here's the basic structure of an XML configuration file:

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Bean definitions go here -->

</beans>
```

### Defining Beans and Dependencies Using XML

To define a bean in the XML configuration file, you use the `<bean>` element. Each bean element must have an `id` attribute (a unique identifier) and a `class` attribute (the fully qualified class name of the bean).

#### Defining a Simple Bean

Here's an example of defining a simple bean:

```xml
<bean id="myBean" class="com.example.MyClass" />
```

#### Defining Bean Dependencies

If a bean has dependencies, you can inject them using the `<constructor-arg>` or `<property>` elements.

- **Constructor Injection:** Use the `<constructor-arg>` element to inject dependencies through the constructor.
- **Setter Injection:** Use the `<property>` element to inject dependencies through setter methods.

##### Constructor Injection

```xml
<bean id="repository" class="com.example.Repository" />

<bean id="service" class="com.example.Service">
    <constructor-arg ref="repository" />
</bean>
```

In this example, the `service` bean depends on the `repository` bean, which is injected via the constructor.

##### Setter Injection

```xml
<bean id="repository" class="com.example.Repository" />

<bean id="service" class="com.example.Service">
    <property name="repository" ref="repository" />
</bean>
```

In this example, the `service` bean depends on the `repository` bean, which is injected via a setter method.

### Example: XML Configuration of a Simple Spring Application

Let's walk through an example of a simple Spring application configured using XML. We'll define two beans: `Repository` and `Service`. The `Service` bean will depend on the `Repository` bean.

#### Step 1: Define the Bean Classes

First, let's define our `Repository` and `Service` classes.

```java
package com.example.springdemo;

public class Repository {
    public void save() {
        System.out.println("Data saved!");
    }
}
```

```java
package com.example.springdemo;

public class Service {
private Repository repository;

    // Constructor for Constructor Injection
    public Service(Repository repository) {
        this.repository = repository;
    }

    // Setter for Setter Injection
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```

#### Step 2: Create the XML Configuration File

Next, we'll create an XML configuration file named `applicationContext.xml`.

```xml
<!-- src/main/resources/applicationContext.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the Repository bean -->
    <bean id="repository" class="com.example.springdemo.Repository" />

    <!-- Define the Service bean with constructor injection -->
    <bean id="service" class="com.example.springdemo.Service">
        <constructor-arg ref="repository" />
    </bean>
    
    <!-- Define the Service bean with setter injection (commented out) -->
    <!--
    <bean id="service" class="com.example.springdemo.Service">
        <property name="repository" ref="repository" />
    </bean>
    -->
</beans>
```

In this file, we define the `repository` bean and the `service` bean. The `service` bean is configured to use constructor injection to receive its `repository` dependency.

#### Step 3: Initialize ApplicationContext and Access Beans

Finally, we'll write a main class to initialize the Spring `ApplicationContext` and access the beans defined in our XML configuration.

```java
package com.example.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {
public static void main(String[] args) {
// Load the application context from the XML configuration file
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the service bean from the context
        Service service = context.getBean("service", Service.class);

        // Use the service to perform an action
        service.performAction();

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
```

### Explanation

1. **Define Bean Classes:** We defined `Repository` and `Service` classes. The `Service` class has a constructor for constructor injection and a setter for setter injection.
2. **Create XML Configuration File:** We created `applicationContext.xml` where we defined our beans and specified their dependencies.
3. **Initialize ApplicationContext:** In the `SpringApp` class, we load the `ApplicationContext` from the XML file, retrieve the `Service` bean, and use it to perform an action.

By following these steps, we can see how Spring manages beans and their dependencies using XML configuration.

---

## Conclusion

We've explored XML-based configuration in the Spring Framework. We've discussed the structure of an XML configuration file, how to define beans and their dependencies, and demonstrated a simple Spring application configured using XML.

---
# 3.2. Java-based Configuration
## Introduction

Good morning, everyone! Today, we are going to focus on Java-based configuration in the Spring Framework. Java-based configuration allows us to use Java classes to configure our Spring application, providing a type-safe, refactor-friendly alternative to XML configuration.

We'll cover the `@Configuration` and `@Bean` annotations, how to create and manage beans using Java configuration, and then we'll walk through an example of configuring a simple Spring application using Java-based configuration.

---

### 3.2. Java-based Configuration

### Introduction to @Configuration and @Bean Annotations

#### @Configuration Annotation

The `@Configuration` annotation indicates that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.

Here's a simple example of a configuration class:

```java
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
// Bean definitions go here
}
```

#### @Bean Annotation

The `@Bean` annotation tells Spring that a method annotated with `@Bean` will return an object that should be registered as a bean in the Spring application context. This annotation is used within a class annotated with `@Configuration`.

Here's an example:

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

In this example, the `myBean` method returns an instance of `MyClass` and registers it as a Spring bean.

---

### Creating and Managing Beans Using Java Configuration

Java-based configuration allows us to define beans and manage their dependencies in a more concise and type-safe manner compared to XML. We can define beans, set their properties, and inject dependencies using plain Java methods.

#### Defining a Simple Bean

Let's define a simple bean using Java-based configuration.

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

In this example, the `myBean` method returns an instance of `MyClass` and registers it as a Spring bean.

#### Defining Bean Dependencies

To define bean dependencies, we can use method parameters in `@Bean` methods or reference other bean methods directly.

##### Constructor Injection

```java
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
        return new Service(repository());
    }
}
```

In this example, the `service` bean depends on the `repository` bean, which is injected via the constructor.

##### Setter Injection

```java
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

In this example, the `service` bean depends on the `repository` bean, which is injected via a setter method.

---

### Example: Java-based Configuration for a Spring Application

Let's walk through an example of a simple Spring application configured using Java-based configuration. We'll define two beans: `Repository` and `Service`. The `Service` bean will depend on the `Repository` bean.

#### Step 1: Define the Bean Classes

First, let's define our `Repository` and `Service` classes.

```java
package com.example.springdemo;

public class Repository {
public void save() {
System.out.println("Data saved!");
}
}
```

```java
package com.example.springdemo;

public class Service {
private Repository repository;

    // Constructor for Constructor Injection
    public Service(Repository repository) {
        this.repository = repository;
    }

    // Setter for Setter Injection
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```

#### Step 2: Create the Java Configuration Class

Next, we'll create a Java configuration class named `AppConfig`.

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
        return new Service(repository()); // Constructor Injection
        // Service service = new Service();
        // service.setRepository(repository()); // Setter Injection
        // return service;
    }
}
```

In this file, we define the `repository` and `service` beans, and we configure their dependencies using either constructor injection or setter injection.

#### Step 3: Initialize ApplicationContext and Access Beans

Finally, we'll write a main class to initialize the Spring `ApplicationContext` and access the beans defined in our Java configuration.

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

### Explanation

1. **Define Bean Classes:** We defined `Repository` and `Service` classes. The `Service` class has a constructor for constructor injection and a setter for setter injection.
2. **Create Java Configuration Class:** We created `AppConfig` where we defined our beans and specified their dependencies using the `@Bean` annotation.
3. **Initialize ApplicationContext:** In the `SpringApp` class, we initialize the `ApplicationContext` using `AnnotationConfigApplicationContext` and pass our configuration class to it.
4. **Retrieve and Use Beans:** We retrieve the `Service` bean from the context and use it to perform an action.

By following these steps, we can see how Spring manages beans and their dependencies using Java-based configuration.

---

## Conclusion

Today, we've explored Java-based configuration in the Spring Framework. We've discussed the `@Configuration` and `@Bean` annotations, how to create and manage beans using Java configuration, and demonstrated a simple Spring application configured using Java-based configuration.

---

# 3.3. Annotation-based Configuration

---

## Introduction

Good morning, everyone! Today, we are going to focus on annotation-based configuration in the Spring Framework. Annotation-based configuration leverages Java annotations to configure beans and their dependencies, providing a more concise and readable approach compared to XML or Java-based configurations.

We'll cover the key annotations like `@Component`, `@Autowired`, `@Qualifier`, and `@ComponentScan`, explain how to configure component scanning and autowiring, and then walk through an example of using annotations to simplify Spring configuration.

---

### 3.3. Annotation-based Configuration

### Introduction to Key Annotations

#### @Component

The `@Component` annotation is used to mark a Java class as a Spring component. It indicates that an annotated class is a Spring-managed bean. Spring will automatically detect these classes through classpath scanning and register them as beans in the application context.

```java
import org.springframework.stereotype.Component;

@Component
public class MyClass {
// Bean definition
}
```

#### @Autowired

The `@Autowired` annotation is used for automatic dependency injection. Spring’s dependency injection can be applied to constructors, methods, and fields. When Spring finds an `@Autowired` annotation, it will automatically inject the appropriate bean.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    // Other methods
}
```

#### @Qualifier

The `@Qualifier` annotation is used in conjunction with `@Autowired` to resolve ambiguity when multiple beans of the same type exist. It allows us to specify exactly which bean should be injected.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    @Autowired
    @Qualifier("mySpecificRepository")
    private MyRepository repository;

    // Other methods
}
```

#### @ComponentScan

The `@ComponentScan` annotation is used with the `@Configuration` annotation to specify the packages that Spring should scan for annotated components. It helps in automatically discovering and registering beans in the application context.

```java
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springdemo")
public class AppConfig {
// Configuration class
}
```

---

### Configuring Component Scanning and Autowiring

Component scanning and autowiring simplify the process of managing bean dependencies. With annotations, we can automatically discover beans and inject dependencies without explicitly defining them in a configuration file.

#### Step 1: Define the Bean Classes

First, let's define our `Repository` and `Service` classes using annotations.

```java
package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Repository {
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
private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```

In these examples, we use `@Component` to mark the classes as Spring components and `@Autowired` to inject dependencies.

#### Step 2: Create the Configuration Class

Next, we'll create a Java configuration class to enable component scanning.

```java
package com.example.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springdemo")
public class AppConfig {
// Configuration class
}
```

#### Step 3: Initialize ApplicationContext and Access Beans

Finally, we'll write a main class to initialize the Spring `ApplicationContext` and access the beans defined using annotations.

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

### Explanation

1. **Define Bean Classes:** We defined `Repository` and `Service` classes and annotated them with `@Component` to mark them as Spring-managed beans. The `Service` class has a constructor annotated with `@Autowired` for dependency injection.
2. **Create Configuration Class:** We created `AppConfig`, a configuration class annotated with `@Configuration` and `@ComponentScan` to enable component scanning in the specified package.
3. **Initialize ApplicationContext:** In the `SpringApp` class, we initialize the `ApplicationContext` using `AnnotationConfigApplicationContext` and pass our configuration class to it.
4. **Retrieve and Use Beans:** We retrieve the `Service` bean from the context and use it to perform an action.

By following these steps, we can see how Spring manages beans and their dependencies using annotations, simplifying the configuration process.

---

### Example: Using Annotations to Simplify Spring Configuration

Let's walk through a complete example of a Spring application configured using annotations.

#### Step 1: Define the Bean Classes

```java
package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Repository {
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
private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void performAction() {
        repository.save();
    }
}
```

#### Step 2: Create the Configuration Class

```java
package com.example.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springdemo")
public class AppConfig {
// Configuration class
}
```

#### Step 3: Initialize ApplicationContext and Access Beans

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

### Explanation

1. **Define Bean Classes:** We defined `Repository` and `Service` classes. The `Service` class has a constructor for constructor injection and a setter for setter injection.
2. **Create Configuration Class:** We created `AppConfig`, a configuration class annotated with `@Configuration` and `@ComponentScan` to enable component scanning in the specified package.
3. **Initialize ApplicationContext:** In the `SpringApp` class, we initialize the `ApplicationContext` using `AnnotationConfigApplicationContext` and pass our configuration class to it.
4. **Retrieve and Use Beans:** We retrieve the `Service` bean from the context and use it to perform an action.

By following these steps, we can see how Spring manages beans and their dependencies using annotations, simplifying the configuration process.

---

## Conclusion

Today, we've explored annotation-based configuration in the Spring Framework. We've discussed the key annotations like `@Component`, `@Autowired`, `@Qualifier`, and `@ComponentScan`, explained how to configure component scanning and autowiring, and demonstrated a simple Spring application configured using annotations.

---

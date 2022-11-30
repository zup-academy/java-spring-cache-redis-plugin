# **Java Spring Cache Redis Plugin**

Java Spring Cache Redis Plugin is a set of technologies and development methodology that together help to use Redis as a distributed cache provider in Java Spring Boot Applications.

This Plugin has support for projects created with Stack Java Spring Boot REST API. And given that it also supports Java Spring Boot projects that use **Maven** as a dependency manager and have their property settings in the **YAML** pattern.


In the next sections you will find detailed information on how to use Java Spring Cache Redis Plugin to enable the ability to use Redis as Distributed Cache in your projects.

Below is a summary of each section of this documentation.

1. [Plugin Core Technologies](#plugin-core-technologies)
2. [Capabilities Enabled when using the Plugin](#what-are-the-capabilities-enabled)
3. [Benefits of using the Plugin](#what-are-the-benefits-of-using-java-spring-cache-redis-plugin)
4. [Applying Java Spring Cache Redis Plugin](#applying-java-spring-cache-redis-plugin)


## **Plugin core technologies**

The purpose of this session is to inform which technologies are part of the Java Spring Cache Redis Plugin.

By applying this plugin to a Spring Boot Java project, your application can benefit from the entire Spring Cache tool infrastructure to provide method caching, allowing I/O flow and CPU bound to be cached in order to provide improvements in the performance of your project.


### **Technological Composition**

The definition of this Plugin was designed aiming at the greatest pains in the use of Redis as a cache of Java applications.

We understand that quality is non-negotiable, and we look to technologies and methodologies as a means to obtain the much-desired software quality. This premise was the guide for choosing each technology detailed below.


- Production environment
    - Spring Cache
    - Spring Data Redis
    - Lettuce Client
- Test environment
    - JUnit
    - Test Containers
- Development environment
    - Docker Compose
        - Redis Container


## **What are the capabilities Enabled**

By applying the Java Spring Cache Redis Plugin to your Java Spring Boot project, your project will be able to:

1. Use Redis distributed caching at various points in the System
2. Configure custom settings for various Caches and
3. Create an automated integration test suite with TestContainers
4. Create Integrated Tests in order to validate Cache behavior
5. Development environment set up next to Docker with Docker-compose.



## **What are the benefits of using Java Spring Cache Redis Plugin**

1. Ease of creating Redis caches in your project through the StackSpot CLI.
2. Ease of defining caching through Spring Boot abstractions.
3. Default configuration of cache behavior based on best practices.
4. Custom configuration for each Cache.
5. Sample codes on how to add values ​​to the Cache based on best practices.
6. Sample codes on how to invalidate values ​​in the Cache based on good practices.
7. Integration Test example codes to validate cache consumption behavior.
8. Integration Tests sample code to validate cache invalidation behavior.
7. Configuration of the test environment with JUnit and Test Containers.
8. DockerCompose for using Redis in a development environment.


[Watch this video to see the benefits of using Java Spring Cache Redis Plugin in your project](https://youtu.be/-2GJR3e4LDs)


## **Applying Java Spring Cache Redis Plugin**

To apply the Java Spring Cache Redis Plugin in your projects and enjoy its benefits, you must have the StackSpot CLI installed on your machine. [If not, follow this tutorial to install](https://docs.stackspot.com/docs/stk-cli/installation/).

### 1. Import the Stack on your machine

```sh
stk import stack https://github.com/zup-academy/java-springboot-restapi-stack
```

### 2. Now check if the Stack was successfully imported

```sh
stk list stack | grep java-springboot
```

### 3. Apply the Plugin, in your project directory, execute

```sh
stk apply plugin java-springboot-restapi-stack/java-spring-cache-redis-plugin
```

### 4. Check the changes in your project

```sh
git status
```



## Support

If you need help, please open an [issue in Stack's Github repository](https://github.com/zup-academy/java-spring-cache-redis-plugin/issues).
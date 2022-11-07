## Java Spring Cache Redis Plugin

The **java-spring-cache-redis-plugin** enables the ability to use Redis as a distributed Cache in your Java Spring Boot Application.

Applying this plugin into a Spring Boot project will prepare and configure it for all those features:

1. Enables and configures Spring Cache for using do Redis;
2. Configure the Spring Boot Application to run Integration Tests using TestContainers with Redis. It makes it possible to write good tests in order to validate the behavior of the cache layer;
3. Configures Docker Compose with Redis so that you can run your application locally;
4. Generates production and test sample code so that you have a starting point for writing good production integration tests;


## How to use

The following steps show how to apply the plugin to an existing Java Spring Boot application.

1. First, import our stack if you haven't done it yet:
```sh
stk import stack https://github.com/zup-academy/java-springboot-restapi-stack
```

2. Now, in the project directory, apply the plugin and answer all the questions:
```sh
stk apply plugin java-springboot-restapi-stack/java-spring-cache-redis-plugin
```

3. Still inside the project directory, you can verify whether the plugin was applied or not by checking the updated and created files:
```sh
git status
```

Nice! You're ready for production I guess 🥳

[See here the benefits and how you can get the most out of the Java Spring Cache Redis Plugin](http://video-will-be-published.soon/)

## Support

If you need any help, please open an [issue on Plugin's Github repository](https://github.com/zup-academy/java-spring-aws-s3-plugin). 
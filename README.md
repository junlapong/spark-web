# Spark web example

Spark - A tiny Sinatra inspired framework for creating web applications in Java 8 with minimal effort

 * http://sparkjava.com

## Maven

Add the dependency to your `pom.xml`

```xml
<dependency>
    <groupId>com.sparkjava</groupId>
    <artifactId>spark-core</artifactId>
    <version>2.9.1</version>
</dependency>
```

## Coding
```java
public class WebApp implements spark.servlet.SparkApplication {

    private static final Logger log = LoggerFactory.getLogger(WebApp.class);
    private static int COUNT = 1;

    @Override
    public void init() {

        log.debug("***** START *****");

        get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");
            log.debug("{}", COUNT++);
            return new ModelAndView(attributes, "hello.ftl");
        }, new FreeMarkerEngine());
    }
}
```

## Run

    mvn -f pom-war.xml jetty:run

Then open url http://localhost:9080/hello

## Run on web server

To run Spark on a web server (instead of the embedded jetty server), an implementation of the interface spark.servlet.SparkApplication is needed. You have to initialize the routes in the init() method, and the following filter has to be configured in your web.xml

```xml
<filter>
    <filter-name>SparkFilter</filter-name>
    <filter-class>spark.servlet.SparkFilter</filter-class>
    <init-param>
        <param-name>applicationClass</param-name>
        <param-value>com.company.YourApplication</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>SparkFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

## Examples

### 1. Spark App (jar package)

please see `pom.xml`, you can test with mvn as example below

    mvn test exec:java

or build jar package and run

    mvn clean package
    java -jar target/spark-app-01.jar

### 2. Spark Web (war package)

please see `pom-war.xml` you can test with mvn as example below

    mvn -f pom-war.xml jetty:run

or build war package and deploy to serverlet container

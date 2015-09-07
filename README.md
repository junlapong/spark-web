# Spark web example

Spark - A tiny Sinatra inspired framework for creating web applications in Java 8 with minimal effort

 * http://sparkjava.com

## Maven

Add the dependency to your POM.xml:

	<dependency>
	    <groupId>com.sparkjava</groupId>
	    <artifactId>spark-core</artifactId>
	    <version>2.2</version>
	</dependency>

## Coding 

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

## Run on web server

To run Spark on a web server (instead of the embedded jetty server), an implementation of the interface spark.servlet.SparkApplication is needed. You have to initialize the routes in the init() method, and the following filter has to be configured in your web.xml

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


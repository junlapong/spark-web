package io.github.junlapong.spark;

import static spark.Spark.secure;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

@Slf4j
public class SparkApp {

    public static void main(String[] args) {

    	log.info("***** Spark Java App *****");

    	spark.Spark.port(9443);
        secure("keystore.p12", "P@ssw0rd", null, null);
    	log.debug("URL: https://localhost:9443/hello");

    	get("/hello", (request, response) -> {
            log.debug("hello");
    	    Map<String, Object> attributes = new HashMap<>();
    	    attributes.put("message", "Hello World!");
    	    return new ModelAndView(attributes, "hello.ftl");
    	}, new FreeMarkerEngine());
    }
}

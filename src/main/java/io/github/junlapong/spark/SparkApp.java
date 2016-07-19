package io.github.junlapong.spark;

import static spark.Spark.secure;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class SparkApp {

    private static final Logger log = LoggerFactory.getLogger(SparkApp.class);

    public static void main(String[] args) {

    	log.debug("***** Spark as Java App *****");

    	spark.Spark.port(9443);
        secure("keystore.p12", "P@ssw0rd", null, null);
    	log.debug("URL: https://localhost:9443/hello");

    	get("/hello", (request, response) -> {
    	    Map<String, Object> attributes = new HashMap<>();
    	    attributes.put("message", "Hello World!");
    	    return new ModelAndView(attributes, "hello.ftl");
    	}, new FreeMarkerEngine());
    }
}

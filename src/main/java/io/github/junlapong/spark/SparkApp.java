package io.github.junlapong.spark;

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
	log.debug("***** START *****");

	spark.Spark.port(9090);
	log.debug("URL: http://localhost:9090/hello");

	get("/hello", (request, response) -> {
	    Map<String, Object> attributes = new HashMap<>();
	    attributes.put("message", "Hello World!");
	    return new ModelAndView(attributes, "hello.ftl");
	}, new FreeMarkerEngine());
    }
}

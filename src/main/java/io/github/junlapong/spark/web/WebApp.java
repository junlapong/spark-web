package io.github.junlapong.spark.web;

import static spark.Spark.get;
import static spark.Spark.redirect;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class WebApp implements spark.servlet.SparkApplication {

    private static final Logger log = LoggerFactory.getLogger(WebApp.class);

    @Override
    public void init() {

    	log.debug("***** Spark on Servlet Container *****");
        redirect.any("/", "/hello");

    	// get("/hello", (req, res) -> "Hello World (Jetty)");
        get("/hello", (request, response) -> {

            log.debug("request");
    	    Map<String, Object> attributes = new HashMap<>();
    	    attributes.put("message", "Hello Spark (on Jetty)");
    	    return new ModelAndView(attributes, "hello.ftl");

    	}, new FreeMarkerEngine());
    }
}

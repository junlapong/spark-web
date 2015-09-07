package io.github.junlapong.spark.web;

import static spark.Spark.get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebApp implements spark.servlet.SparkApplication {

    private static final Logger log = LoggerFactory.getLogger(WebApp.class);

    @Override
    public void init() {

	log.debug("***** START *****");

	get("/hello", (req, res) -> "Hello World");

    }
}

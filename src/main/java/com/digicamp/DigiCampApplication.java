package com.digicamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DigiCampApplication {
    private static final Logger logger = LogManager.getLogger(DigiCampApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DigiCampApplication.class, args);
//        logger.trace("We've just greeted the user!");
//        logger.debug("We've just greeted the user!");
//        logger.info("We've just greeted the user!");
//        logger.warn("We've just greeted the user!");
//        logger.error("We've just greeted the user!");
//        logger.fatal("We've just greeted the user!");
    }

}

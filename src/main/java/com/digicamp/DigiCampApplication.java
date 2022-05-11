package com.digicamp;

import com.digicamp.dao.RoleDao;
import com.digicamp.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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


    @Bean
    public CommandLineRunner initialData(RoleDao roleDao) {
        return args -> {
            if (!roleDao.existsById(1)) {
                roleDao.save(new Role("student","Student"));
            }
            if (!roleDao.existsById(2)) {
                roleDao.save(new Role("admin","Admin"));
            }
        };
    }
}

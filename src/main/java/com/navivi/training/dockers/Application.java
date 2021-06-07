package com.navivi.training.dockers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("\n ================================================ \n         Training-Dockers SERVER IS UP \n ================================================ \n");
        log.debug("------ This is Debug message ------");
    }




}
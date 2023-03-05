package com.projects.igritdatacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IgritDataCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IgritDataCollectorApplication.class, args);
    }

}

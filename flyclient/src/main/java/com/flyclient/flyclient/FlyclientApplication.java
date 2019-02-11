package com.flyclient.flyclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class FlyclientApplication {

    @Component
    public static void main(String[] args) {
        SpringApplication.run(FlyclientApplication.class, args);
    }

}


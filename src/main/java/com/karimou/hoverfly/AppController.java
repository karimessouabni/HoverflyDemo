package com.karimou.hoverfly;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class AppController {
    private static final Logger LOGGER = Logger.getLogger(AppController.class.getName());
    private static int number = 0;


    @GetMapping(value = "/fly")
    public Fly getAFly() {

        LOGGER.warning("current Thread is =" + Thread.currentThread().toString());


        return Fly.builder()
                .name("bee" + number++)
                .nickName("zee")
                .age(UUID.randomUUID().toString())
                .build();
    }


}




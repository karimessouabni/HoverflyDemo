package com.flyclient.flyclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ClientAndTestController {

    private static final int HOVERFLY_PORT = 8500;
    private static final String HOVERFLY_HOST = "localhost";


    private static final Logger LOGGER = Logger.getLogger(ClientAndTestController.class.getName());


    @Autowired
    RestTemplate restTemplate;



    @Bean
    public RestTemplate restTemplate() {

        String mode = System.getProperty("mode");
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(HOVERFLY_HOST, HOVERFLY_PORT));
        requestFactory.setProxy(proxy);

        if (mode.equalsIgnoreCase("proxy")) {
            LOGGER.log(Level.CONFIG, "######### Running application in PROXY mode");
            return new RestTemplate(requestFactory);
        } else {
            LOGGER.log(Level.CONFIG, "######### Running application in PRODUCTION mode ");
            return new RestTemplate();
        }
    }



    @GetMapping("/getMyFly")
    public String invoke() {
        System.out.println("inside Bee ClientAndTestController");
        String url = "http://localhost:8070/fly";


        return restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                }).getBody();

    }


}

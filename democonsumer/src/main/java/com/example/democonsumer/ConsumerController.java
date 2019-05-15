package com.example.democonsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate template;
    @GetMapping("/ribbon-consumer")
    public String helleConsumer(){
        return template.getForEntity("http://hello-service/getUser",String.class).getBody();
    }
}

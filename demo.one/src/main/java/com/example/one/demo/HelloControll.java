package com.example.one.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControll {


    private final static Logger logger= LoggerFactory.getLogger(HelloControll.class);
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getUser")
    public String findUser(){
        ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
       logger.info("/getUser,host:"+localServiceInstance.getHost()+",service_id:"+localServiceInstance.getServiceId());
        System.out.println("/getUser,host:"+localServiceInstance.getHost()+",service_id:"+localServiceInstance.getServiceId());
        return "hello String!";
    }

}

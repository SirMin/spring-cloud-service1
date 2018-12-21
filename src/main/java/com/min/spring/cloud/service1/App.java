package com.min.spring.cloud.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By minzhiwei On 2018/12/21 16:11
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class App {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("dc")
    public String dc() {
        final String s = "Services:" + discoveryClient.getServices();
        System.out.println(s);
        return s;
    }

    @GetMapping("test")
    public String test() {
        System.out.println("aaaa");
        return "服务1的测试";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

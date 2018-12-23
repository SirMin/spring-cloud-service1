package com.min.spring.cloud.service1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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

    @PostMapping(value = "uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("file")MultipartFile multipartFile) throws IOException {
        final ByteBuffer wrap = ByteBuffer.wrap(multipartFile.getBytes());
        final String name = multipartFile.getOriginalFilename();
        final FileChannel channel = new FileOutputStream("C:\\file\\" + name).getChannel();
        channel.write(wrap);
        channel.close();
        return name + "已经收到";
    }

    @GetMapping("test1")
    public String test1() {
        return "test1";
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

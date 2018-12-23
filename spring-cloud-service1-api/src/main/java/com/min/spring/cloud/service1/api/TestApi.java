package com.min.spring.cloud.service1.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * CREATE BY 2018/12/22
 *
 * @author sirmin
 */
//@FeignClient(value = "service1", configuration = MultipartSupportConfig.class)
@FeignClient(value = "service1")
public interface TestApi {
    @GetMapping("/test")
    String test();

    @PostMapping(value = "uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart("file") MultipartFile multipartFile) throws IOException;
}

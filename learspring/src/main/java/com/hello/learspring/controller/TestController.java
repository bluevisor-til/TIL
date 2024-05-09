package com.hello.learspring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        log.debug("test controller");
        return "안녕하세요!!!";
    }

    // * 경로 변수
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.debug("test2 controller");
        return "안녕하세요!!!";
    }

    // * 다중 맵핑
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath2(@PathVariable String userId, @PathVariable Long orderId) {
        log.debug("userId = {}, orderId = {}", userId, orderId);
        return "OK";
    }
}
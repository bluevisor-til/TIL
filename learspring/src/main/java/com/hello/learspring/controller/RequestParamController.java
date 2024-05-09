package com.hello.learspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
public class RequestParamController {

    // * 쿼리 파라미터, HTML FORM
    @RequestMapping("/requestParam-v1")
    public void requestParamV1(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));
        log.debug("username={}, age={}", username, age);

        res.getWriter().write("ok");
    }

    //    @ResponseBody
    @RequestMapping("/requestParam-v2")
    public String requestParamV2(
            @RequestParam("username") String username
            , @RequestParam("age") int age) {
        log.debug("reqeuset v2 = username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("/requestParam-v3")
    public String requestParamV3(
            @RequestParam String username
            , @RequestParam int age) {
        log.debug("reqeuset v3 = username={}, age={}", username, age);
        return "ok";
    }

    // * HTTP 파라미터랑 변수 이름이 같으면 생략 가능
    @RequestMapping("/requestParam-v4")
    public String requestParamV4(String username, int age) {
        log.debug("reqeuset v4 = username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.debug("model-attribute-v1 username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.debug("model-attribute-v2 username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}

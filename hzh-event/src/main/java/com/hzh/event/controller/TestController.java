package com.hzh.event.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 测试类
 * @Author: FXS) Hzh
 * @Date: 2023/6/21 15:48
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


    @GetMapping("/helloReeor")
    public String helloReeor() {
        int i = 1/0;
        return "Hello World";
    }
}

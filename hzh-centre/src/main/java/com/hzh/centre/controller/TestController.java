package com.hzh.centre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试接口
 * @Author: FXS) Hzh
 * @Date: 2023/3/22 16:55
 */
@RestController
@RequestMapping("/test")
public class TestController {



    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }


}

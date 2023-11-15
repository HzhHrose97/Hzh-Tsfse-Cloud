package com.hzh.event.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 16:15
 */
@RestController
@RequestMapping("/api")
public class TestOpenfeignController {

    @GetMapping("/event/test")
    public String test(){
        return "Test Openfeign Event Success!!!";
    }

}

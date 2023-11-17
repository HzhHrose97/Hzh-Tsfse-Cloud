package com.hzh.event.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 测试 order 作为消费者 消费event当中的服务
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 16:15
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestEventOpenfeignController {

    @GetMapping("/event/test")
    public String test(){
        return "Hzh-Event   Test Openfeign Event Success!!!";
    }

}

package com.hzh.event.controller.openfiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 赛事中心feign接口
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:52
 */
@FeignClient(name="eventService")
public class TestEventClientController {

    @GetMapping("api/event/test")
    public String getEventTest(){
        return "test";
    }

}

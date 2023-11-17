package com.hzh.common.openfiegn.event;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 赛事中心feign接口  提供者
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:52
 */
@FeignClient(name="eventService")
public interface EventClient {

    //测试fallback全局异常
    @RequestMapping(value = "/hzh-event/api/event/test",method = RequestMethod.GET)
    String getEventTest() ;


}

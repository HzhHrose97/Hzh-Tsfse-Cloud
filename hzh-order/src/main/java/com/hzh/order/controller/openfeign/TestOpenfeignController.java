package com.hzh.order.controller.openfeign;

import com.hzh.common.openfiegn.EventClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:58
 */
@Api(tags = "OpenFeign API")
@RestController
public class TestOpenfeignController {


    @Resource
    private  EventClient eventClient;

    @ApiOperation(value = "测试获取hzh-event中的接口",tags = "hzh-event")
    @GetMapping("/constroller/openfeign")
    public String consumeEventResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = eventClient.getEventTest();
        return eventTest;
    }


}



package com.hzh.order.controller.api;

import com.hzh.common.openfiegn.centre.CentreClient;
import com.hzh.common.openfiegn.event.EventClient;
import com.hzh.common.openfiegn.team.TeamClient;
import com.hzh.common.openfiegn.user.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: EventClient 消费者
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:58
 */
@Api(tags = "OpenFeign API")
@RestController
public class TestController {

    @Resource
    private  EventClient eventClient;

    @Resource
    private CentreClient centreClient;

    @Resource
    private TeamClient teamClient;

    @Resource
    private UserClient userClient;

    @ApiOperation(value = "测试获取hzh-event中的接口",tags = "hzh-event")
    @GetMapping("/event/openfeign")
    public String consumeEventResource() {
        System.out.println("执行了consumeEventResource()");
        //测试 全局fallback
        String eventTest = eventClient.getEventTest();
        return eventTest;
    }

    @ApiOperation(value = "测试获取hzh-centre中的接口",tags = "hzh-centre中的接口")
    @GetMapping("/centre/openfeign")
    public String consumeCentreResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = centreClient.getCentreTest();
        return eventTest;
    }

    @ApiOperation(value = "测试获取hzh-teamt中的接口",tags = "hzh-team")
    @GetMapping("/team/openfeign")
    public String consumeTeamResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = teamClient.getTeamTest();
        return eventTest;
    }

    @ApiOperation(value = "测试获取hzh-user中的接口",tags = "hzh-user")
    @GetMapping("/user/openfeign")
    public String consumeUserResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = userClient.getUserTest();
        return eventTest;
    }





}



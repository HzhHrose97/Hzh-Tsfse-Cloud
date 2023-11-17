package com.hzh.order.controller.api;

import com.hzh.common.openfiegn.centre.CentreClient;
import com.hzh.common.openfiegn.event.EventClient;
import com.hzh.common.openfiegn.team.TeamClient;
import com.hzh.common.openfiegn.user.UserClient;
import com.hzh.common.respone.MyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: EventClient 消费者
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:58
 */
@Slf4j
@Api("订单中心")
@RestController
public class TestAndConsumeController {

    @Resource
    private  EventClient eventClient;

    @Resource
    private CentreClient centreClient;

    @Resource
    private TeamClient teamClient;

    @Resource
    private UserClient userClient;

    @ApiOperation(value = "测试获取hzh-event中的接口",tags = "OpenFeign API")
    @GetMapping("/event/openfeign")
    public String consumeEventResource() {
        System.out.println("执行了consumeEventResource()");
        //测试 全局fallback
        String eventTest = eventClient.getEventTest();
        return eventTest;
    }

    @ApiOperation(value = "测试获取hzh-centre中的接口",tags = "OpenFeign API")
    @GetMapping("/centre/openfeign")
    public String consumeCentreResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = centreClient.getCentreTest();
        return eventTest;
    }

    @ApiOperation(value = "测试获取hzh-teamt中的接口",tags = "OpenFeign API")
    @GetMapping("/team/openfeign")
    public String consumeTeamResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = teamClient.getTeamTest();
        return eventTest;
    }

    @ApiOperation(value = "测试获取hzh-user中的接口",tags = "OpenFeign API")
    @GetMapping("/user/openfeign")
    public String consumeUserResource() {
        System.out.println("执行了consumeEventResource()");
        String eventTest = userClient.getUserTest();
        return eventTest;
    }


    @ApiOperation(value = "获取所有篮球球队信息" ,tags = "远程调用球队中心")
    @PostMapping("/getAllBashetballTeamInfo")
    public MyResult getAllBashetballTeamInfo(){
        try {
            MyResult allBashetballTeamInfo = teamClient.getAllBashetballTeamInfo();
            return MyResult.SUCCESS("远程调用球队中心 成功",allBashetballTeamInfo);
        }catch (Exception e){
            log.error("getAllBashetballTeamInfo  error",e);
            throw new RuntimeException("getAllBashetballTeamInfo error");
        }
    }


    @ApiOperation(value = "获取所有篮球赛事信息" ,tags = "远程调用赛事中心")
    @PostMapping("/getAllBashetballEventInfo")
    public MyResult getAllBashetballEventInfo(){
        try {
            MyResult allBashetballEventInfo = eventClient.getAllBashetballEventInfo();
            return MyResult.SUCCESS("远程调用赛事中心 成功",allBashetballEventInfo);
        }catch (Exception e){
            log.error("getAllBashetballEventInfo  error",e);
            throw new RuntimeException("getAllBashetballEventInfo error");
        }
    }

    @ApiOperation(value = "获取所有中国城市信息" ,tags = "远程调用共享中心")
    @PostMapping("/getAllCentreChinaCityInfo")
    public MyResult getAllCentreChinaCityInfo(){
        try {
            MyResult allCentreChinaCityInfo = centreClient.getAllCentreChinaCityInfo();
            return MyResult.SUCCESS("远程调用共享中心 成功",allCentreChinaCityInfo);
        }catch (Exception e){
            log.error("getAllCentreChinaCityInfo  error",e);
            throw new RuntimeException("getAllCentreChinaCityInfo error");
        }
    }


    @ApiOperation(value = "获取所有用户信息" ,tags = "远程调用用户中心")
    @PostMapping("/getAllUserInfo")
    public MyResult getAllUserInfo(){
        try {
            MyResult allUserInfo = userClient.getAllUserInfo();
            return MyResult.SUCCESS("远程调用用户中心 成功",allUserInfo);
        }catch (Exception e){
            log.error("getAllUserInfo  error",e);
            throw new RuntimeException("getAllUserInfo error");
        }
    }


}



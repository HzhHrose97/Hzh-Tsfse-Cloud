package com.hzh.event.controller.api;

import com.hzh.common.pojo.event.BasketballEventInfo;
import com.hzh.event.service.BasketballEventInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzh.common.respone.MyResult;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: openfeign 提供者
 * @Author: FXS) Hzh
 * @Date: 2023/11/17 15:44
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class BasketBallApiController {

    @Resource
    private BasketballEventInfoService basketballEventInfoService;
    @GetMapping("/basketball/getAllBashetballEventInfo")
    @ApiOperation(value ="获取全部篮球订单信息",tags = "Openfeign API")
    public MyResult getAllBashetballEventInfo(){
        try {
            List<BasketballEventInfo> allBashetballEventInfo = basketballEventInfoService.getAllBashetballEventInfo();
            return MyResult.SUCCESS("getAllBashetballEventInfo Success",allBashetballEventInfo);
        }catch (Exception e){
            log.error("getAllBashetballEventInfo  error",e);
            throw new RuntimeException("getAllBashetballEventInfo error");
        }
    }



}

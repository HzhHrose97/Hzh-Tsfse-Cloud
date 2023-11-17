package com.hzh.team.controller.api;

import com.hzh.common.pojo.team.BasketballTeamInfo;
import com.hzh.common.respone.MyResult;
import com.hzh.team.service.BasketballTeamInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: openfeign 提供者
 * @Author: FXS) Hzh
 * @Date: 2023/11/17 16:16
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class TeamApiController {

    @Resource
    private BasketballTeamInfoService basketballTeamInfoService;


    @GetMapping("/team/getAllBashetballTeamInfo")
    @ApiOperation(value ="获取全部篮球订单信息",tags = "Openfeign API")
    public MyResult getAllBasketBallTeamInfo(){
        try {
            List<BasketballTeamInfo> allBasketBallTeamInfo = basketballTeamInfoService.getAllBasketBallTeamInfo();
            return MyResult.SUCCESS("getAllBasketBallTeamInfo Success",allBasketBallTeamInfo);
        }catch (Exception e){
            log.error("getAllBasketBallTeamInfo  error",e);
            throw new RuntimeException("getAllBasketBallTeamInfo error");
        }
    }


}

package com.hzh.team.controller;


import com.hzh.common.pojo.team.BasketballTeamInfo;
import com.hzh.common.respone.Result;
import com.hzh.team.service.BasketballTeamInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 球队信息表 前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@Api("球队中心")
@RestController
@RequestMapping("/basketballTeamInfo")
public class BasketballTeamInfoController {

    @Resource
    public BasketballTeamInfoService basketballTeamInfoService;

    @GetMapping("/getAllBasketBallTeamInfo")
    @ApiOperation(value = "获取篮球队伍全部信息",tags = "篮球队伍")
    public Result getAllBasketBallTeamInfo(){
        try {
            List<BasketballTeamInfo> basketballTeamInfoList = basketballTeamInfoService.getAllBasketBallTeamInfo();
            return Result.SUCCESS("getAllBasketBallTeamInfo success ",basketballTeamInfoList);
        }catch (Exception e){
            log.error("getAllBasketBallTeamInfo  error",e);
            throw new RuntimeException("getAllBasketBallTeamInfo error");
        }
    }


}


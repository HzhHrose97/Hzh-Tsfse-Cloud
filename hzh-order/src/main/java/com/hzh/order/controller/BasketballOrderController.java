package com.hzh.order.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.centre.openfeign.HzhEventClient;
import com.hzh.centre.openfeign.HzhTeamClinet;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.BasketballOrder;
import com.hzh.common.respone.Result;
import com.hzh.order.service.BasketballOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@CrossOrigin
@Api(tags = "订单中心")
@RestController
@RequestMapping("/basketballOrder")
public class BasketballOrderController {

    @Resource
    public BasketballOrderService basketballOrderService;

    @Resource
    private HzhEventClient hzhEventClient;

    @Resource
    private HzhTeamClinet hzhTeamClinet;

    @ApiOperation(value = "获取篮球订单全部信息",tags = "篮球订单")
    @GetMapping("/getAllBasketBallInfo")
    public Result getAllBasketBallInfo(){
        try {
            List<BasketballOrder> basketballOrdersList =  basketballOrderService.getAllBasketBallInfo();
            return Result.SUCCESS("getAllBasketBallInfo success",basketballOrdersList);
        }catch (Exception e){
            log.error(" getAllBasketBallInfo  error",e);
            throw new RuntimeException("getAllBasketBallInfo error");
        }
    }

    @ApiOperation(value = "分页获取篮球订单全部信息",tags = "篮球订单")
    @PostMapping("/pageGetAllBasketballOrderInfo")
    public Result pageGetAllBasketballOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<BasketballOrder> page = new Page<>(current, size);
            IPage<BasketballOrder> basketballOrderIPage = basketballOrderService.selectPage(page);
            return Result.SUCCESS("pageGetAllBasketballOrderInfo success",basketballOrderIPage);
        }catch (Exception e){
            log.error("pageGetAllBasketballOrderInfo  error",e);
            throw new RuntimeException("pageGetAllBasketballOrderInfo error");
        }
    }

    @ApiOperation(value = "订单中心  测试远程调用  赛事中心" ,tags = "篮球订单 远程调用赛事中心")
    @PostMapping("/getAllBashetballEventInfo")
    public Result getAllBashetballEventInfo(){
        try {
            Result allBashetballEventInfo = hzhEventClient.getAllBashetballEventInfo();
            return Result.SUCCESS("远程调用赛事中心 成功",allBashetballEventInfo);
        }catch (Exception e){
            log.error("getAllBashetballEventInfo  error",e);
            throw new RuntimeException("getAllBashetballEventInfo error");
        }
    }

    @ApiOperation(value = "订单中心  测试远程调用  球队中心" ,tags = "篮球订单 远程调用球队中心")
    @PostMapping("/getAllBashetballTeamInfo")
    public Result getAllBashetballTeamInfo(){
        try {
            Result allBashetballTeamInfo = hzhTeamClinet.getAllBashetballTeamInfo();
            return Result.SUCCESS("远程调用球队中心 成功",allBashetballTeamInfo);
        }catch (Exception e){
            log.error("getAllBashetballEventInfo  error",e);
            throw new RuntimeException("getAllBashetballEventInfo error");
        }
    }

}


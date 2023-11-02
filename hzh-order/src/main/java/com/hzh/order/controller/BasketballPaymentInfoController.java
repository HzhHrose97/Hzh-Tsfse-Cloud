package com.hzh.order.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.BasketballPaymentInfo;
import com.hzh.common.respone.MyResult;
import com.hzh.order.service.BasketballPaymentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 支付信息表 前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@CrossOrigin
@Api(tags = "订单中心")
@RestController
@RequestMapping("/basketballPaymentInfo")
public class BasketballPaymentInfoController {

    @Resource
    public BasketballPaymentInfoService basketballPaymentInfoService;

    @ApiOperation(value = "获取篮球订单支付的全部信息",tags = "篮球订单")
    @GetMapping("/getAllBasketBallInfo")
    public MyResult getAllBasketBallInfo(){
        try {
            List<BasketballPaymentInfo> basketballPaymentInfos =  basketballPaymentInfoService.getAllBasketBallPaymentInfoInfo();
            return MyResult.SUCCESS("getAllBasketBallInfo success",basketballPaymentInfos);
        }catch (Exception e){
            log.error(" getAllBasketBallInfo  error",e);
            throw new RuntimeException("getAllBasketBallInfo error");
        }
    }

    @ApiOperation(value = "分页获取篮球订单支付的全部信息",tags = "篮球订单")
    @PostMapping("/pageGetAllBasketballOrderInfo")
    public MyResult pageGetAllBasketballOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<BasketballPaymentInfo> page = new Page<>(current, size);
            IPage<BasketballPaymentInfo> basketballPaymentInfoIPage = basketballPaymentInfoService.selectPage(page);
            return MyResult.SUCCESS("pageGetAllBasketballOrderInfo success",basketballPaymentInfoIPage);
        }catch (Exception e){
            log.error("pageGetAllBasketballOrderInfo  error",e);
            throw new RuntimeException("pageGetAllBasketballOrderInfo error");
        }
    }

}


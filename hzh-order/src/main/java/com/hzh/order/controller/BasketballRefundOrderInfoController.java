package com.hzh.order.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.BasketballPaymentInfo;
import com.hzh.common.pojo.order.BasketballRefundOrderInfo;
import com.hzh.common.respone.Result;
import com.hzh.order.service.BasketballPaymentInfoService;
import com.hzh.order.service.BasketballRefundOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 退款信息 前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@CrossOrigin
@Api("订单中心")
@RestController
@RequestMapping("/basketballRefundOrderInfo")
public class BasketballRefundOrderInfoController {

    @Resource
    public BasketballRefundOrderInfoService basketballRefundOrderInfoService;

    @ApiOperation(value = "获取篮球订单退款的全部信息",tags = "篮球订单")
    @GetMapping("/getAllBasketballRefundOrderInfo")
    public Result getAllBasketballRefundOrderInfo(){
        try {
            List<BasketballRefundOrderInfo> basketballRefundOrderInfos =  basketballRefundOrderInfoService.getAllBasketBallRefundOrderInfo();
            return Result.SUCCESS("getAllBasketballRefundOrderInfo success",basketballRefundOrderInfos);
        }catch (Exception e){
            log.error(" getAllBasketballRefundOrderInfo  error",e);
            throw new RuntimeException("getAllBasketballRefundOrderInfo error");
        }
    }

    @ApiOperation(value = "分页获取篮球订单退款的全部信息",tags = "篮球订单")
    @PostMapping("/pageGetAllBasketballRefundOrderInfo")
    public Result pageGetAllBasketballRefundOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<BasketballRefundOrderInfo> page = new Page<>(current, size);
            IPage<BasketballRefundOrderInfo> basketballRefundOrderInfoIPage = basketballRefundOrderInfoService.selectPage(page);
            return Result.SUCCESS("pageGetAllBasketballRefundOrderInfo success",basketballRefundOrderInfoIPage);
        }catch (Exception e){
            log.error("pageGetAllBasketballRefundOrderInfo  error",e);
            throw new RuntimeException("pageGetAllBasketballRefundOrderInfo error");
        }
    }


}


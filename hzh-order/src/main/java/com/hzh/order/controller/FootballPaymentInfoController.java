package com.hzh.order.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.FootballPaymentInfo;
import com.hzh.common.respone.Result;
import com.hzh.order.service.FootballPaymentInfoService;
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
@RequestMapping("/footballPaymentInfo")
public class FootballPaymentInfoController {

    @Resource
    public FootballPaymentInfoService footballPaymentInfoService;

    @ApiOperation(value = "获取足球订单支付的全部信息",tags = "足球订单")
    @GetMapping("/getAllFootballInfo")
    public Result getAllFootballInfo(){
        try {
            List<FootballPaymentInfo> footballPaymentInfos =  footballPaymentInfoService.getAllFootballPaymentInfoInfo();
            return Result.SUCCESS("getAllFootballInfo success",footballPaymentInfos);
        }catch (Exception e){
            log.error(" getAllFootballInfo  error",e);
            throw new RuntimeException("getAllFootballInfo error");
        }
    }

    @ApiOperation(value = "分页获取足球订单支付的全部信息",tags = "足球订单")
    @PostMapping("/pageGetAllFootballOrderInfo")
    public Result pageGetAllFootballOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<FootballPaymentInfo> page = new Page<>(current, size);
            IPage<FootballPaymentInfo> footballPaymentInfoIPage = footballPaymentInfoService.selectPage(page);
            return Result.SUCCESS("pageGetAllFootballOrderInfo success",footballPaymentInfoIPage);
        }catch (Exception e){
            log.error("pageGetAllFootballOrderInfo  error",e);
            throw new RuntimeException("pageGetAllFootballOrderInfo error");
        }
    }

}


package com.hzh.order.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.FootballRefundOrderInfo;
import com.hzh.common.respone.MyResult;
import com.hzh.order.service.FootballRefundOrderInfoService;
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
@RequestMapping("/footballRefundOrderInfo")
public class FootballRefundOrderInfoController {

    @Resource
    public FootballRefundOrderInfoService footballRefundOrderInfoService;

    @ApiOperation(value = "获取足球订单退款的全部信息",tags = "足球订单")
    @GetMapping("/getAllFootballRefundOrderInfo")
    public MyResult getAllFootballRefundOrderInfo(){
        try {
            List<FootballRefundOrderInfo> footballRefundOrderInfos =  footballRefundOrderInfoService.getAllFootballRefundOrderInfo();
            return MyResult.SUCCESS("getAllFootballRefundOrderInfo success",footballRefundOrderInfos);
        }catch (Exception e){
            log.error(" getAllFootballRefundOrderInfo  error",e);
            throw new RuntimeException("getAllFootballRefundOrderInfo error");
        }
    }

    @ApiOperation(value = "分页获取足球订单退款的全部信息",tags = "足球订单")
    @PostMapping("/pageGetAllFootballRefundOrderInfo")
    public MyResult pageGetAllFootballRefundOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<FootballRefundOrderInfo> page = new Page<>(current, size);
            IPage<FootballRefundOrderInfo> footballRefundOrderInfoIPage = footballRefundOrderInfoService.selectPage(page);
            return MyResult.SUCCESS("pageGetAllFootballRefundOrderInfo success",footballRefundOrderInfoIPage);
        }catch (Exception e){
            log.error("pageGetAllFootballRefundOrderInfo  error",e);
            throw new RuntimeException("pageGetAllFootballRefundOrderInfo error");
        }
    }

}


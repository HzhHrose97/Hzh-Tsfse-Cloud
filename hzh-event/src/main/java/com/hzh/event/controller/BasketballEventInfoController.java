package com.hzh.event.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.event.BasketballEventInfo;
import com.hzh.common.respone.MyResult;
import com.hzh.event.service.BasketballEventInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 体育赛事举办信息表 前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@Api(tags = "赛事中心")
@CrossOrigin
@RestController
@RequestMapping("/basketballEventInfo")
public class BasketballEventInfoController {

    @Resource
    public BasketballEventInfoService basketballEventInfoService;

    @ApiOperation(value = "获取篮球赛事全部信息(包含历史赛事)",tags = "篮球赛事")
    @GetMapping("/getAllBashetballEventInfo")
    public MyResult getAllBashetballEventInfo(){
        try {
            List<BasketballEventInfo> basketballEventInfoList =  basketballEventInfoService.getAllBashetballEventInfo();
            return MyResult.SUCCESS("getAllBashetballEventInfo success",basketballEventInfoList);
        }catch (Exception e){
            log.error(" getAllBashetballEventInfo  error",e);
            throw new RuntimeException("getAllBashetballEventInfo error");
        }
    }

    @ApiOperation(value = "分页获取篮球赛事全部信息(包含历史赛事)",tags = "篮球赛事")
    @PostMapping("/pageGetAllBashetballEvent")
    public MyResult pageGetAllBashetballEvent(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<BasketballEventInfo> page = new Page<>(current, size);
            IPage<BasketballEventInfo> basketballEventInfoIPage = basketballEventInfoService.selectPage(page);
            return MyResult.SUCCESS("pageGetAllBashetballEvent success",basketballEventInfoIPage);
        }catch (Exception e){
            log.error("pageGetAllBashetballEvent  error",e);
            throw new RuntimeException("pageGetAllBashetballEvent error");
        }
    }


}


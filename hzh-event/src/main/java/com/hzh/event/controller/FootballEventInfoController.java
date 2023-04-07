package com.hzh.event.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.event.FootballEventInfo;
import com.hzh.common.respone.Result;
import com.hzh.event.service.FootballEventInfoService;
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
@CrossOrigin
@Api(tags = "赛事中心")
@RestController
@RequestMapping("/footballEventInfo")
public class FootballEventInfoController {

    @Resource
    public FootballEventInfoService footballEventInfoService;

    @ApiOperation(value = "获取足球赛事全部信息(包含历史赛事)",tags = "足球赛事")
    @GetMapping("/getAllfootballEventInfo")
    public Result getAllfootballEventInfo(){
        try {
            List<FootballEventInfo> footballEventInfos =  footballEventInfoService.getAllfootballEventInfo();
            return Result.SUCCESS("getAllfootballEventInfo success",footballEventInfos);
        }catch (Exception e){
            log.error(" getAllfootballEventInfo  error",e);
            throw new RuntimeException("getAllfootballEventInfo error");
        }
    }

    @ApiOperation(value = "分页获取足球赛事全部信息(包含历史赛事)",tags = "足球赛事")
    @PostMapping("/pageGetAllfootballEvent")
    public Result pageGetAllfootballEvent(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<FootballEventInfo> page = new Page<>(current, size);
            IPage<FootballEventInfo> footballEventInfoIPage = footballEventInfoService.selectPage(page);
            return Result.SUCCESS("pageGetAllfootballEvent success",footballEventInfoIPage);
        }catch (Exception e){
            log.error("pageGetAllfootballEvent  error",e);
            throw new RuntimeException("pageGetAllfootballEvent error");
        }
    }


}


package com.hzh.team.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.team.BasketballCoachInfo;
import com.hzh.common.respone.MyResult;
import com.hzh.team.service.BasketballCoachInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/basketballCoachInfo")
@Api(tags = "球队中心")
public class BasketballCoachInfoController {

    @Resource
    public BasketballCoachInfoService basketballCoachInfoService;

    @PostMapping("/pageGetBasketAll")
    @ApiOperation("分页获取所有篮球队伍信息")
    public MyResult pageGetBasketAll(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<BasketballCoachInfo> page = new Page<>(current, size);
            IPage<BasketballCoachInfo> basketballCoachInfoIPage =  basketballCoachInfoService.selectPage(page);
            return MyResult.SUCCESS("basketballCoachInfoIPage success");
        }catch (Exception e){
            log.error("pageGetBasketAll error",e);
            throw new RuntimeException("pageGetBasketAll error");
        }
    }

}


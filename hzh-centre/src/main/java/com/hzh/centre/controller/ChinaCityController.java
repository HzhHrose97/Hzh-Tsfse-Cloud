package com.hzh.centre.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.centre.service.ChinaCityService;
import com.hzh.common.pojo.centre.ChinaCity;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.respone.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-20
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/chinaCity")
@Api(tags = "共享中心")
public class ChinaCityController {

    @Resource
    public ChinaCityService chinaCityService;

    @ApiOperation("获取全部中国城市")
    @GetMapping("/getAllChinaCity")
    public Result getAllChinaCity(){
        try{
            List<ChinaCity> chinaCityList = chinaCityService.getAllChinaCity();
            return Result.SUCCESS("getAllChinaCity success",chinaCityList);
        }catch (Exception e){
            log.error("getAllChinaCity error",e);
            throw new RuntimeException("getAllChinaCity error");
        }
    }

    @ApiOperation("分页获取中国城市")
    @PostMapping("/paginationGetAll")
    public Result paginationGetAll(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<ChinaCity> page = new Page<>(current, size);
            IPage<ChinaCity> physicalHeldInfoIPage = chinaCityService.selectPage(page);
            return Result.SUCCESS("paginationGetAll success",physicalHeldInfoIPage);
        }catch (Exception e){
            log.error("paginationGetAll  error",e);
            throw new RuntimeException("paginationGetAll error");
        }
    }

}


package com.hzh.centre.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.centre.service.GlobalLocationService;
import com.hzh.common.pojo.centre.GlobalLocation;
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
@Slf4j
@CrossOrigin
@Api(tags = "共享中心")
@RestController
@RequestMapping("/globalLocation")
public class GlobalLocationController {

    @Resource
    public GlobalLocationService globalLocationService;

    @ApiOperation("获取全球城市信息")
    @GetMapping("getAllGlobalLocationGetAll")
    public Result globalLocationGetAll(){
        try {
            List<GlobalLocation> globalLocationList =  globalLocationService.globalLocationGetAll();
            return Result.SUCCESS("globalLocationGetAll success",globalLocationList);
        }catch (Exception e){
            log.error("globalLocationGetAll error",e);
            throw new RuntimeException("globalLocationGetAll error");
        }
    }

    @PostMapping("/globalGetAllpagination")
    @ApiOperation("分页获取全球城市信息")
    public Result globalGetAllpagination(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<GlobalLocation> page = new Page<>(current, size);
            IPage<GlobalLocation> globalLocationIPage =  globalLocationService.selectPage(page);
            return Result.SUCCESS("globalGetAllpagination success",globalLocationIPage);
        }catch (Exception e){
            log.error("globalGetAllpagination  error",e);
            throw new RuntimeException("globalGetAllpagination error");
        }
    }


}



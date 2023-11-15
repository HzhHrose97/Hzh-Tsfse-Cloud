package com.hzh.order.controller.football;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.FootballOrder;
import com.hzh.common.respone.MyResult;
import com.hzh.order.service.football.FootballOrderService;
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
@RequestMapping("/footballOrder")
public class FootballOrderController {

    @Resource
    public FootballOrderService footballOrderService;

    @ApiOperation(value = "获取足球订单全部信息",tags = "足球订单")
    @GetMapping("/getAllFootballInfo")
    public MyResult getAllFootballInfo(){
        try {
            List<FootballOrder> footballOrdersList =  footballOrderService.getAllFootballInfo();
            return MyResult.SUCCESS("getAllFootballInfo success",footballOrdersList);
        }catch (Exception e){
            log.error(" getAllFootballInfo  error",e);
            throw new RuntimeException("getAllFootballInfo error");
        }
    }

    @ApiOperation(value = "分页获取足球订单全部信息",tags = "足球订单")
    @PostMapping("/pageGetAllFootballOrderInfo")
    public MyResult pageGetAllFootballOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<FootballOrder> page = new Page<>(current, size);
            IPage<FootballOrder> footballOrderIPage = footballOrderService.selectPage(page);
            return MyResult.SUCCESS("pageGetAllFootballOrderInfo success",footballOrderIPage);
        }catch (Exception e){
            log.error("pageGetAllFootballOrderInfo  error",e);
            throw new RuntimeException("pageGetAllFootballOrderInfo error");
        }
    }

}


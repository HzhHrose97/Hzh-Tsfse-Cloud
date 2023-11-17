package com.hzh.order.controller.basketball;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.order.BasketballOrder;
import com.hzh.common.respone.MyResult;
import com.hzh.common.utils.DateUtils;
import com.hzh.common.utils.RedisKeyUtil;
import com.hzh.common.utils.RedisUtils;
import com.hzh.order.service.basketball.BasketballOrderService;
import com.mysql.cj.util.StringUtils;
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
@Api("订单中心")
@CrossOrigin
@RestController
@RequestMapping("/basketballOrder")
public class BasketballOrderController {

    @Resource
    private BasketballOrderService basketballOrderService;

    @Resource
    private RedisKeyUtil redisKeyUtil;

    @Resource
    private RedisUtils redisUtils;

    @ApiOperation(value = "获取篮球订单全部信息",tags = "篮球订单")
    @GetMapping("/getAllBasketBallInfo")
    public MyResult getAllBasketBallInfo(){
        try {
            List<BasketballOrder> basketballOrdersList =  basketballOrderService.getAllBasketBallInfo();
            return MyResult.SUCCESS("getAllBasketBallInfo success",basketballOrdersList);
        }catch (Exception e){
            log.error(" getAllBasketBallInfo  error",e);
            throw new RuntimeException("getAllBasketBallInfo error");
        }
    }

    @ApiOperation(value = "分页获取篮球订单全部信息",tags = "篮球订单")
    @PostMapping("/pageGetAllBasketballOrderInfo")
    public MyResult pageGetAllBasketballOrderInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<BasketballOrder> page = new Page<>(current, size);
            IPage<BasketballOrder> basketballOrderIPage = basketballOrderService.selectPage(page);
            return MyResult.SUCCESS("pageGetAllBasketballOrderInfo success",basketballOrderIPage);
        }catch (Exception e){
            log.error("pageGetAllBasketballOrderInfo  error",e);
            throw new RuntimeException("pageGetAllBasketballOrderInfo error");
        }
    }

    @PostMapping("/addBashetballOrderInfo")
    @ApiOperation(value = "新增篮球订单",tags = "篮球订单")
    public MyResult addBashetballOrderInfo(@RequestBody BasketballOrder basketballOrder){
        try {
            if (basketballOrder == null){
                return MyResult.FAILED("请求参数为空");
            }else {
                //订单创建日期
                String createOrderData = DateUtils.getCurrent(DateUtils.datePattern); //2023/03/07
                String basketballRediskey = redisKeyUtil.mkBasketBallOrderInfo(basketballOrder.getOrderId(),basketballOrder.getUserId(),createOrderData);
                String redisValue = redisUtils.get(basketballRediskey);
                if (StringUtils.isNullOrEmpty(redisValue)){
                    Integer redisAppend = redisUtils.append(basketballRediskey, String.valueOf(basketballOrder));
                    Integer DBAppend = basketballOrderService.addBashetballOrderInfo(basketballOrder);
                    if (redisAppend > 0 && DBAppend == 1){
                        return MyResult.SUCCESS("篮球订单新增成功");
                    }else {
                        return MyResult.FAILED("篮球订单新增失败");
                    }
                }else {
                    redisUtils.delete(basketballRediskey);
                    Integer append = redisUtils.append(basketballRediskey, String.valueOf(basketballOrder));
                    Integer DBupdate = basketballOrderService.updateaBashetballOrderInfo(basketballOrder);
                    if (append > 1 && DBupdate == 1){
                        return MyResult.SUCCESS("篮球订单新增成功");
                    }else {
                        return MyResult.FAILED("篮球订单新增失败");
                    }
                }
            }
        }catch (Exception e){
            log.error("addBashetballOrderInfo  error",e);
            throw new RuntimeException("addBashetballOrderInfo error");
        }
    }


}


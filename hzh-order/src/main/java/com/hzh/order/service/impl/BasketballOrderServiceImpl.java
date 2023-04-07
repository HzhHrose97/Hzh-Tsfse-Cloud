package com.hzh.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.BasketballOrder;
import com.hzh.common.mapper.order.BasketballOrderMapper;
import com.hzh.order.service.BasketballOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class BasketballOrderServiceImpl extends ServiceImpl<BasketballOrderMapper, BasketballOrder> implements BasketballOrderService {

    @Resource
    public BasketballOrderMapper basketballOrderMapper;

    @Override
    public List<BasketballOrder> getAllBasketBallInfo() {
        try {
            List<BasketballOrder> basketballOrders = basketballOrderMapper.selectList(null);
            return basketballOrders;
        }catch (Exception e){
            log.error("getAllBasketBallInfo error",e);
            throw new RuntimeException("getAllBasketBallInfo error");
        }
    }

    @Override
    public IPage<BasketballOrder> selectPage(Page<BasketballOrder> page) {
        try {
            Page<BasketballOrder> basketballOrderPage = basketballOrderMapper.selectPage(page, null);
            return basketballOrderPage;
        }catch (Exception e){
            log.error("BasketballOrderServiceImpl selectPage error",e);
            throw new RuntimeException("BasketballOrderServiceImpl selectPage error");
        }
    }
}

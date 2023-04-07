package com.hzh.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.BasketballRefundOrderInfo;
import com.hzh.common.mapper.order.BasketballRefundOrderInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.order.service.BasketballRefundOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.PushBuilder;
import java.util.List;

/**
 * <p>
 * 退款信息 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class BasketballRefundOrderInfoServiceImpl extends ServiceImpl<BasketballRefundOrderInfoMapper, BasketballRefundOrderInfo> implements BasketballRefundOrderInfoService {

    @Resource
    public BasketballRefundOrderInfoMapper basketballRefundOrderInfoMapper;
    @Override
    public List<BasketballRefundOrderInfo> getAllBasketBallRefundOrderInfo() {
        try {
            List<BasketballRefundOrderInfo> basketballRefundOrderInfos = basketballRefundOrderInfoMapper.selectList(null);
            return basketballRefundOrderInfos;
        }catch (Exception e){
            log.error("getAllBasketBallRefundOrderInfo error",e);
            throw new RuntimeException("getAllBasketBallRefundOrderInfo error");
        }
    }

    @Override
    public IPage<BasketballRefundOrderInfo> selectPage(Page<BasketballRefundOrderInfo> page) {
        try {
            Page<BasketballRefundOrderInfo> basketballRefundOrderInfoPage = basketballRefundOrderInfoMapper.selectPage(page, null);
            return basketballRefundOrderInfoPage;
        }catch (Exception e){
            log.error("BasketballRefundOrderInfoServiceImpl selectPage error",e);
            throw new RuntimeException("BasketballRefundOrderInfoServiceImpl selectPage error");
        }
    }
}

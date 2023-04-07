package com.hzh.order.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.BasketballPaymentInfo;
import com.hzh.common.mapper.order.BasketballPaymentInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.order.service.BasketballPaymentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 支付信息表 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class BasketballPaymentInfoServiceImpl extends ServiceImpl<BasketballPaymentInfoMapper, BasketballPaymentInfo> implements BasketballPaymentInfoService {

    @Resource
    public BasketballPaymentInfoMapper basketballPaymentInfoMapper;
    @Override
    public List<BasketballPaymentInfo> getAllBasketBallPaymentInfoInfo() {
        try {
            List<BasketballPaymentInfo> basketballPaymentInfos = basketballPaymentInfoMapper.selectList(null);
            return basketballPaymentInfos;
        }catch (Exception e){
            log.error("getAllBasketBallPaymentInfoInfo error",e);
            throw new RuntimeException("getAllBasketBallPaymentInfoInfo error");
        }
    }

    @Override
    public IPage<BasketballPaymentInfo> selectPage(Page<BasketballPaymentInfo> page) {
        try {
            Page<BasketballPaymentInfo> basketballPaymentInfoPage = basketballPaymentInfoMapper.selectPage(page, null);
            return basketballPaymentInfoPage;
        }catch (Exception e){
            log.error("BasketballPaymentInfoServiceImpl selectPage error",e);
            throw new RuntimeException("BasketballPaymentInfoServiceImpl selectPage error");
        }
    }
}

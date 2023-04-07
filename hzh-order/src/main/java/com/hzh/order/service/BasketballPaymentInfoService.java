package com.hzh.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.BasketballPaymentInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 支付信息表 服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface BasketballPaymentInfoService extends IService<BasketballPaymentInfo> {

    List<BasketballPaymentInfo> getAllBasketBallPaymentInfoInfo();

    IPage<BasketballPaymentInfo> selectPage(Page<BasketballPaymentInfo> page);
}

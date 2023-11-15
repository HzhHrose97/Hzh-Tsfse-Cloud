package com.hzh.order.service.basketball;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.BasketballRefundOrderInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 退款信息 服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface BasketballRefundOrderInfoService extends IService<BasketballRefundOrderInfo> {


    List<BasketballRefundOrderInfo> getAllBasketBallRefundOrderInfo();

    IPage<BasketballRefundOrderInfo> selectPage(Page<BasketballRefundOrderInfo> page);
}

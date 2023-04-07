package com.hzh.order.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.BasketballOrder;
import com.hzh.common.pojo.order.FootballOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface FootballOrderService extends IService<FootballOrder> {

    List<FootballOrder> getAllFootballInfo();

    IPage<FootballOrder> selectPage(Page<FootballOrder> page);
}

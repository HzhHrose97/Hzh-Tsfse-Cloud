package com.hzh.order.service.football;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.FootballRefundOrderInfo;
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
public interface FootballRefundOrderInfoService extends IService<FootballRefundOrderInfo> {

    List<FootballRefundOrderInfo> getAllFootballRefundOrderInfo();

    IPage<FootballRefundOrderInfo> selectPage(Page<FootballRefundOrderInfo> page);
}

package com.hzh.order.service.football;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.FootballPaymentInfo;
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
public interface FootballPaymentInfoService extends IService<FootballPaymentInfo> {

    List<FootballPaymentInfo> getAllFootballPaymentInfoInfo();

    IPage<FootballPaymentInfo> selectPage(Page<FootballPaymentInfo> page);
}

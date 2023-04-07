package com.hzh.team.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzh.common.pojo.team.BasketballCoachInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface BasketballCoachInfoService extends IService<BasketballCoachInfo> {

    IPage<BasketballCoachInfo> selectPage(Page<BasketballCoachInfo> page);
}

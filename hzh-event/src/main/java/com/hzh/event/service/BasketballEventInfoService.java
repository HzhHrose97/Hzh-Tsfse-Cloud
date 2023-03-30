package com.hzh.event.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.event.BasketballEventInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 体育赛事举办信息表 服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface BasketballEventInfoService extends IService<BasketballEventInfo> {

    List<BasketballEventInfo> getAllBashetballEventInfo();

    IPage<BasketballEventInfo> selectPage(Page<BasketballEventInfo> page);
}

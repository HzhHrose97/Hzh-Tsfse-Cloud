package com.hzh.centre.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzh.common.pojo.centre.ChinaCity;
import com.hzh.common.pojo.centre.GlobalLocation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-20
 */
public interface GlobalLocationService extends IService<GlobalLocation> {

    List<GlobalLocation> globalLocationGetAll();

    IPage<GlobalLocation> selectPage(Page<GlobalLocation> page);
}

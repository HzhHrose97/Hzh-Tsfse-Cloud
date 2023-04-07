package com.hzh.team.service;

import com.hzh.common.pojo.team.BasketballTeamInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 球队信息表 服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface BasketballTeamInfoService extends IService<BasketballTeamInfo> {

    List<BasketballTeamInfo> getAllBasketBallTeamInfo();

}

package com.hzh.team.service.impl;

import com.hzh.common.pojo.team.BasketballTeamInfo;
import com.hzh.common.mapper.team.BasketballTeamInfoMapper;
import com.hzh.team.service.BasketballTeamInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 球队信息表 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class BasketballTeamInfoServiceImpl extends ServiceImpl<BasketballTeamInfoMapper, BasketballTeamInfo> implements BasketballTeamInfoService {

    @Resource
    public BasketballTeamInfoMapper basketballTeamInfoMapper;
    @Override
    public List<BasketballTeamInfo> getAllBasketBallTeamInfo() {
        try {
            List<BasketballTeamInfo> basketballTeamInfos = basketballTeamInfoMapper.selectList(null);
            return basketballTeamInfos;
        }catch (Exception e){
            log.error("getAllBasketBallTeamInfo error",e);
            throw new RuntimeException("getAllBasketBallTeamInfo error");
        }
    }
}

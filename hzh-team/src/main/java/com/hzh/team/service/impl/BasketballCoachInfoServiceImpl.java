package com.hzh.team.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.common.mapper.team.BasketballCoachInfoMapper;
import com.hzh.common.pojo.team.BasketballCoachInfo;
import com.hzh.team.service.BasketballCoachInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class BasketballCoachInfoServiceImpl extends ServiceImpl<BasketballCoachInfoMapper, BasketballCoachInfo> implements BasketballCoachInfoService {

    @Resource
    public  BasketballCoachInfoMapper basketballCoachInfoMapper;

    @Override
    public IPage<BasketballCoachInfo> selectPage(Page<BasketballCoachInfo> page) {
        try {
            Page<BasketballCoachInfo> basketballCoachInfoPage = basketballCoachInfoMapper.selectPage(page, null);
            return basketballCoachInfoPage;
        }catch (Exception e){
            log.error("BasketballCoachInfoServiceImpl selectPage error",e);
            throw new RuntimeException("BasketballCoachInfoServiceImpl selectPage  error");
        }
    }
}

package com.hzh.event.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.event.BasketballEventInfo;
import com.hzh.common.mapper.event.BasketballEventInfoMapper;
import com.hzh.event.service.BasketballEventInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 体育赛事举办信息表 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class BasketballEventInfoServiceImpl extends ServiceImpl<BasketballEventInfoMapper, BasketballEventInfo> implements BasketballEventInfoService {

    @Resource
    public BasketballEventInfoMapper basketballEventInfoMapper;
    @Override
    public List<BasketballEventInfo> getAllBashetballEventInfo() {
        try {
            List<BasketballEventInfo> basketballEventInfos = basketballEventInfoMapper.selectList(null);
            return basketballEventInfos;
        }catch (Exception e){
            log.error("getAllBashetballEventInfo error",e);
            throw new RuntimeException("getAllBashetballEventInfo error");
        }
    }

    @Override
    public IPage<BasketballEventInfo> selectPage(Page<BasketballEventInfo> page) {
        try {
            Page<BasketballEventInfo> basketballEventInfoPage = basketballEventInfoMapper.selectPage(page, null);
            return basketballEventInfoPage;
        }catch (Exception e){
            log.error("BasketballEventInfoServiceImpl selectPage error",e);
            throw new RuntimeException("BasketballEventInfoServiceImpl selectPage error");
        }
    }
}

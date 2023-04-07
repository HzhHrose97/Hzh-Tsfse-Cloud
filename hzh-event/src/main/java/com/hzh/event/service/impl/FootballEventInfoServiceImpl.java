package com.hzh.event.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.event.FootballEventInfo;
import com.hzh.common.mapper.event.FootballEventInfoMapper;
import com.hzh.event.service.FootballEventInfoService;
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
public class FootballEventInfoServiceImpl extends ServiceImpl<FootballEventInfoMapper, FootballEventInfo> implements FootballEventInfoService {

    @Resource
    public FootballEventInfoMapper footballEventInfoMapper;
    @Override
    public List<FootballEventInfo> getAllfootballEventInfo() {
        try {
            List<FootballEventInfo> footballEventInfos = footballEventInfoMapper.selectList(null);
            return footballEventInfos;
        }catch (Exception e){
            log.error("getAllfootballEventInfo error",e);
            throw new RuntimeException("getAllfootballEventInfo error");
        }
    }

    @Override
    public IPage<FootballEventInfo> selectPage(Page<FootballEventInfo> page) {
        try {
            Page<FootballEventInfo> footballEventInfoPage = footballEventInfoMapper.selectPage(page, null);
            return footballEventInfoPage;
        }catch (Exception e){
            log.error("FootballEventInfoServiceImpl selectPage error",e);
            throw new RuntimeException("FootballEventInfoServiceImpl selectPage error");
        }
    }
}

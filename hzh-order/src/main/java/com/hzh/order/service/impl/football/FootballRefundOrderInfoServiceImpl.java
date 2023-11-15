package com.hzh.order.service.impl.football;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.FootballRefundOrderInfo;
import com.hzh.common.mapper.order.FootballRefundOrderInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.order.service.football.FootballRefundOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 退款信息 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class FootballRefundOrderInfoServiceImpl extends ServiceImpl<FootballRefundOrderInfoMapper, FootballRefundOrderInfo> implements FootballRefundOrderInfoService {

    @Resource
    public FootballRefundOrderInfoMapper footballRefundOrderInfoMapper;
    @Override
    public List<FootballRefundOrderInfo> getAllFootballRefundOrderInfo() {
       try {
           List<FootballRefundOrderInfo> footballRefundOrderInfos = footballRefundOrderInfoMapper.selectList(null);
           return footballRefundOrderInfos;
       }catch (Exception e){
           log.error("getAllFootballRefundOrderInfo error",e);
           throw new RuntimeException("getAllFootballRefundOrderInfo error");
       }
    }

    @Override
    public IPage<FootballRefundOrderInfo> selectPage(Page<FootballRefundOrderInfo> page) {
        try {
            Page<FootballRefundOrderInfo> footballRefundOrderInfoPage = footballRefundOrderInfoMapper.selectPage(page, null);
            return footballRefundOrderInfoPage;
        }catch (Exception e){
            log.error("FootballRefundOrderInfoServiceImpl selectPage error",e);
            throw new RuntimeException("FootballRefundOrderInfoServiceImpl selectPage error");
        }
    }
}

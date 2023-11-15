package com.hzh.order.service.impl.football;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.FootballPaymentInfo;
import com.hzh.common.mapper.order.FootballPaymentInfoMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.order.service.football.FootballPaymentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 支付信息表 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class FootballPaymentInfoServiceImpl extends ServiceImpl<FootballPaymentInfoMapper, FootballPaymentInfo> implements FootballPaymentInfoService {

    @Resource
    public FootballPaymentInfoMapper footballPaymentInfoMapper;
    @Override
    public List<FootballPaymentInfo> getAllFootballPaymentInfoInfo() {
        try {
            List<FootballPaymentInfo> footballPaymentInfos = footballPaymentInfoMapper.selectList(null);
            return footballPaymentInfos;
        }catch (Exception e){
            log.error("getAllFootballPaymentInfoInfo error",e);
            throw new RuntimeException("getAllFootballPaymentInfoInfo error");
        }
    }

    @Override
    public IPage<FootballPaymentInfo> selectPage(Page<FootballPaymentInfo> page) {
        try {
            Page<FootballPaymentInfo> footballPaymentInfoPage = footballPaymentInfoMapper.selectPage(page, null);
            return footballPaymentInfoPage;
        }catch (Exception e){
            log.error("FootballPaymentInfoServiceImpl selectPage error",e);
            throw new RuntimeException("FootballPaymentInfoServiceImpl selectPage error");
        }
    }
}

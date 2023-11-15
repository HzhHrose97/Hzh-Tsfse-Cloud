package com.hzh.order.service.impl.football;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.order.FootballOrder;
import com.hzh.common.mapper.order.FootballOrderMapper;
import com.hzh.order.service.football.FootballOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class FootballOrderServiceImpl extends ServiceImpl<FootballOrderMapper, FootballOrder> implements FootballOrderService {

    @Resource
    public FootballOrderMapper footballOrderMapper;
    @Override
    public List<FootballOrder> getAllFootballInfo() {
        try {
            List<FootballOrder> footballOrders = footballOrderMapper.selectList(null);
            return footballOrders;
        }catch (Exception e){
            log.error("getAllFootballInfo error",e);
            throw new RuntimeException("getAllFootballInfo error");
        }
    }

    @Override
    public IPage<FootballOrder> selectPage(Page<FootballOrder> page) {
        try {
            Page<FootballOrder> footballOrderPage = footballOrderMapper.selectPage(page, null);
            return footballOrderPage;
        }catch (Exception e){
            log.error("FootballOrderServiceImpl selectPage error",e);
            throw new RuntimeException("FootballOrderServiceImpl selectPage error");
        }
    }
}

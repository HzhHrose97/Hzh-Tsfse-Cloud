package com.hzh.centre.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.centre.service.ChinaCityService;
import com.hzh.common.mapper.centre.ChinaCityMapper;
import com.hzh.common.pojo.centre.ChinaCity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-20
 */
@Service
public class ChinaCityServiceImpl extends ServiceImpl<ChinaCityMapper, ChinaCity> implements ChinaCityService {

    @Resource
    public ChinaCityMapper chinaCityMapper;


    @Override
    public List<ChinaCity> getAllChinaCity() {
        try {
            List<ChinaCity> chinaCityList = chinaCityMapper.selectList(null);
            return chinaCityList;
        }catch (Exception e){
            log.error("getAllChinaCity error",e);
            throw new RuntimeException("getAllChinaCity error");
        }
    }

    @Override
    public IPage<ChinaCity> selectPage(Page<ChinaCity> page) {
        try {
            Page<ChinaCity> chinaCityPage = chinaCityMapper.selectPage(page, null);
            return chinaCityPage;
        }catch (Exception e){
            log.error("ChinaCityServiceImpl selectPage error",e);
            throw new RuntimeException("ChinaCityServiceImpl selectPage error");
        }
    }
}

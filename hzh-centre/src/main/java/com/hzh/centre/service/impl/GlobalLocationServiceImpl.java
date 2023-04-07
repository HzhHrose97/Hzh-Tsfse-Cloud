package com.hzh.centre.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzh.centre.service.GlobalLocationService;
import com.hzh.common.mapper.centre.GlobalLocationMapper;
import com.hzh.common.pojo.centre.ChinaCity;
import com.hzh.common.pojo.centre.GlobalLocation;
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
public class GlobalLocationServiceImpl extends ServiceImpl<GlobalLocationMapper, GlobalLocation> implements GlobalLocationService {

    @Resource
    public GlobalLocationMapper globalLocationMapper;
    @Override
    public List<GlobalLocation> globalLocationGetAll() {
           try {
               List<GlobalLocation> globalLocations = globalLocationMapper.selectList(null);
               return globalLocations;
           }catch (Exception e){
                  log.error("globalLocationGetAll error",e);
                  throw new RuntimeException("globalLocationGetAll error");
               }
    }

    @Override
    public IPage<GlobalLocation> selectPage(Page<GlobalLocation> page) {
        try {
            IPage<GlobalLocation>  globalLocationIPage = globalLocationMapper.selectPage(page,null);
            return globalLocationIPage;
        }catch (Exception e){
            log.error("GlobalLocationServiceImpl selectPage error",e);
            throw new RuntimeException("GlobalLocationServiceImpl selectPage error");
        }
    }
}

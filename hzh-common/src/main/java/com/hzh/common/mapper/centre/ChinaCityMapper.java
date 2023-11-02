package com.hzh.common.mapper.centre;

import com.hzh.common.pojo.centre.ChinaCity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hzh
 * @since 2023-03-20
 */
@Mapper
@Repository
public interface ChinaCityMapper extends BaseMapper<ChinaCity> {


    List<ChinaCity> getAllChinaCity();
}

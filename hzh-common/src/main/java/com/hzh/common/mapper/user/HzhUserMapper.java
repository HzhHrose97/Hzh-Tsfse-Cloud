package com.hzh.common.mapper.user;

import com.hzh.common.pojo.user.HzhUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Mapper
public interface HzhUserMapper extends BaseMapper<HzhUser> {

    int updatePasswordByuserSelf(@Param("password") String password,
                                     @Param("phonenumber") String phonenumber,
                                     @Param("email") String email,
                                     @Param("date") String date);

    List<HzhUser> getAllUserInfo();

}

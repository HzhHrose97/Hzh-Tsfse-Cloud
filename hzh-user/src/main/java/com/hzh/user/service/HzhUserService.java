package com.hzh.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.RegisterDTO;
import com.hzh.common.pojo.user.HzhUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hzh.common.respone.MyResult;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
public interface HzhUserService extends IService<HzhUser> {

    MyResult registerUser(RegisterDTO registerDTO) throws Exception;

    IPage<HzhUser> selectPage(Page<HzhUser> page);

    MyResult sendEmailCode(String email);

    MyResult updatePasswordByuserSelf(RegisterDTO registerDTO);

    MyResult sendEmailCodeWhenUpdatePassword(String email);

    List<HzhUser> getAllUserInfo();
}

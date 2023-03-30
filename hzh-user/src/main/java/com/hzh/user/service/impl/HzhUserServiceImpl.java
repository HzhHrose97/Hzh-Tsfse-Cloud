package com.hzh.user.service.impl;

import com.hzh.common.pojo.user.HzhUser;
import com.hzh.common.mapper.user.HzhUserMapper;
import com.hzh.user.service.HzhUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Service
public class HzhUserServiceImpl extends ServiceImpl<HzhUserMapper, HzhUser> implements HzhUserService {

}

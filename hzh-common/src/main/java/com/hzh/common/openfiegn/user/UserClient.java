package com.hzh.common.openfiegn.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 赛事中心feign接口  提供者
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:52
 */
@FeignClient(name="userService")
public interface UserClient {

    //测试fallback全局异常
    @RequestMapping(value = "/hzh-user/api/user/test",method = RequestMethod.GET)
    String getUserTest() ;

}

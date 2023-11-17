package com.hzh.user.controller.api;

import com.hzh.common.pojo.user.HzhUser;
import com.hzh.common.respone.MyResult;
import com.hzh.user.service.HzhUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 测试 order 作为消费者 消费event当中的服务
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 16:15
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TestOpenfeignController {

    @Resource
    private HzhUserService hzhUserService;

    @GetMapping("/user/test")
    public String test(){
        return "Hzh-User   Test Openfeign User Success!!!";
    }

    @GetMapping("/user/getAllUserInfo")
    public MyResult getAllUserInfo(){
        List<HzhUser> allUserInfo = hzhUserService.getAllUserInfo();
        return MyResult.SUCCESS("User Info: " + allUserInfo);
    }

}

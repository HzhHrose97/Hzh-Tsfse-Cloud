package com.hzh.user.controller;


import com.hzh.common.pojo.dto.LoginDTO;
import com.hzh.common.respone.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Hzh
 * @since 2023-03-27
 */
@Api(tags = "用户中心")
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/hzhUser")
public class HzhUserController {

    @ApiOperation("测试登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO){
        try {
            if (loginDTO == null){
                return Result.FAILED("用户名或密码为空");
            }else {
                System.out.println("登录用户名：" + loginDTO.getUsername());
                System.out.println("登录密码：" + loginDTO.getPassword());
                return Result.SUCCESS("登录成功");
            }
        }catch (Exception e){
            log.error("login  error",e);
            throw new RuntimeException("login error");
        }
    }


}


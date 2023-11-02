package com.hzh.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzh.common.pojo.dto.LoginDTO;
import com.hzh.common.pojo.dto.PaginationDTO;
import com.hzh.common.pojo.dto.RegisterDTO;
import com.hzh.common.pojo.user.HzhUser;
import com.hzh.common.respone.MyResult;
import com.hzh.user.service.HzhUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    public HzhUserService hzhUserService;

    @ApiOperation("测试登录")
    @PostMapping("/login")
    public MyResult login(@RequestBody LoginDTO loginDTO){
        try {
            if (loginDTO == null){
                return MyResult.FAILED("用户名或密码为空");
            }else {
                System.out.println("登录用户名：" + loginDTO.getUsername());
                System.out.println("登录密码：" + loginDTO.getPassword());
                return MyResult.SUCCESS("登录成功");
            }
        }catch (Exception e){
            log.error("login  error",e);
            throw new RuntimeException("login error");
        }
    }

    @ApiOperation("用户注册")
    @PostMapping("/user/register")
    public MyResult registerUser(@RequestBody RegisterDTO registerDTO) {
        try {
            return hzhUserService.registerUser(registerDTO);
        }catch (Exception e){
            log.error("registerUser error ", e);
            throw new RuntimeException("registerUser error");
        }
    }

    @ApiOperation("分页获取所有用户信息")
    @PostMapping("/user/pageGetAllUserInfo")
    public MyResult pageGetAllUserInfo(@RequestBody PaginationDTO paginationDTO){
        try {
            int current = null == paginationDTO.getCurrent() ? 1 : paginationDTO.getCurrent();
            int size = null == paginationDTO.getSize() ? 10 :  paginationDTO.getSize();
            Page<HzhUser> page = new Page<>(current, size);
            IPage<HzhUser> globalLocationIPage =  hzhUserService.selectPage(page);
            return MyResult.SUCCESS("pageGetAllUserInfo success",globalLocationIPage);
        }catch (Exception e){
            log.error("pageGetAllUserInfo  error",e);
            throw new RuntimeException("pageGetAllUserInfo error");
        }
    }

    @ApiOperation("用户注册时发送邮箱验证码")
    @GetMapping("/user/sendEmailCode")
    public MyResult sendEmailCode(@RequestParam("email")String email){
        try {
            if (email.isEmpty()){
                return MyResult.FAILED("邮箱不可以为空!");
            }
            MyResult meailCode = hzhUserService.sendEmailCode(email);
            return MyResult.SUCCESS("发送成功，请查看注册邮箱",meailCode);
        }catch (Exception e){
            log.error("sendEmailCode error",e);
            throw new RuntimeException("sendEmailCode error");
        }
    }

    @ApiOperation("用户修改密码时发送邮箱验证码")
    @GetMapping("/user/sendEmailCodeWhenUpdatePassword")
    public MyResult sendEmailCodeWhenUpdatePassword(@RequestParam("email")String email){
        try {
            if (email.isEmpty()){
                return MyResult.FAILED("邮箱不可以为空!");
            }
            return  hzhUserService.sendEmailCodeWhenUpdatePassword(email);
        }catch (Exception e){
            log.error("sendEmailCode error",e);
            throw new RuntimeException("sendEmailCode error");
        }
    }

    @ApiOperation("用户根据phone、email修改密码")
    @PostMapping("/user/updatePasswordByuserSelf")
    public MyResult updatePasswordByuserSelf(@RequestBody RegisterDTO registerDTO){
        try {
            if (registerDTO == null){
                return MyResult.FAILED("params not null");
            }else {
               return hzhUserService.updatePasswordByuserSelf(registerDTO);
            }
        }catch (Exception e){
            log.error("updatePasswordByuserSelf  error",e);
            throw new RuntimeException("updatePasswordByuserSelf error");
        }
    }



}


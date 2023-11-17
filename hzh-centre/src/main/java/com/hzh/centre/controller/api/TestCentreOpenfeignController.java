package com.hzh.centre.controller.api;

import com.hzh.centre.service.ChinaCityService;
import com.hzh.common.pojo.centre.ChinaCity;
import com.hzh.common.respone.MyResult;
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
public class TestCentreOpenfeignController {

    @Resource
    private ChinaCityService chinaCityService;

    @GetMapping("/centre/test")
    public String test(){
        return "Hzh-Centre   Test Openfeign Centre Success!!!";
    }

    @GetMapping("centre/getAllCentreChinaCityInfo")
    public MyResult getAllCentreChinaCityInfo(){
        List<ChinaCity> allChinaCity = chinaCityService.getAllChinaCity();
        return MyResult.SUCCESS("AllChinaCity : ",allChinaCity);
    }
}

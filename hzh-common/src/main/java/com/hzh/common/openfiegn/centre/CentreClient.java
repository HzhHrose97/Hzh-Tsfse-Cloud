package com.hzh.common.openfiegn.centre;

import com.hzh.common.respone.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 共享中心feign接口  提供者
 * @Author: FXS) Hzh
 * @Date: 2023/11/17 12:02
 */
@FeignClient("centreService")
public interface CentreClient {

    @RequestMapping(value = "/hzh-centre/api/centre/test",method = RequestMethod.GET)
    String getCentreTest() ;

    @RequestMapping(value = "/hzh-centre/api/centre/getAllCentreChinaCityInfo",method = RequestMethod.GET)
    MyResult getAllCentreChinaCityInfo();
}

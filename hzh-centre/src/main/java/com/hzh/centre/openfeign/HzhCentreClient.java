package com.hzh.centre.openfeign;

import com.hzh.centre.handler.HzhEventClientHandler;
import com.hzh.common.respone.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Hou Zhonghu
 * @since 2022/7/6 17:27
 */
@FeignClient(value = "centreService",fallback = HzhEventClientHandler.class)
public interface HzhCentreClient {

    @RequestMapping(value = "/hzh-centre/chinaCity/getAllChinaCity",method = RequestMethod.GET)
    public MyResult getAllChinaCity();

    @RequestMapping(value = "/hzh-centre/chinaCity/paginationGetAll",method = RequestMethod.GET)
    public MyResult paginationGetAll();

}

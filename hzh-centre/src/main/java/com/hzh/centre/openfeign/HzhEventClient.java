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
@FeignClient(value = "eventService",fallback = HzhEventClientHandler.class)
public interface HzhEventClient {

    @RequestMapping(value = "/hzh-event/basketballEventInfo/getAllBashetballEventInfo",method = RequestMethod.GET)
    public MyResult getAllBashetballEventInfo();

}

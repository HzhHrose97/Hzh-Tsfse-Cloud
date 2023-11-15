package com.hzh.common.openfiegn;

import com.hzh.common.fallback.EventClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: 赛事中心feign接口
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:52
 */
@FeignClient(name="eventService",fallback = EventClientFallback.class)
public interface EventClient {

    @GetMapping("/hzh-event/api/event/test")
    String getEventTest() ;

}

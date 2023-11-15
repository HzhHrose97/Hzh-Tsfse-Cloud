package com.hzh.common.fallback;

import com.hzh.common.openfiegn.EventClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: EventClient 的降级处理类
 * @Author: FXS) Hzh
 * @Date: 2023/11/15 15:54
 */
@Component
public class EventClientFallback implements EventClient {


    @Override
    public String getEventTest() {
        System.out.println("getEventTest 发生熔断异常");
        return "getEventTest 发生熔断异常，请稍后在试";
    }
}

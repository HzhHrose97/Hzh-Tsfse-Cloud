package com.hzh.centre.openfeign;

import com.hzh.centre.handler.HzhOrderClientHandler;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Hou Zhonghu
 * @since 2022/7/7 15:11
 */
@FeignClient(value = "orderService",fallback = HzhOrderClientHandler.class)
public interface HzhOrderClient {

}

package com.hzh.centre.openfeign;

import com.hzh.centre.handler.HzhUserClientHandler;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Hou Zhonghu
 * @since 2022/7/7 15:16
 */
@FeignClient(value = "userService",fallback = HzhUserClientHandler.class)
public interface HzhUserClient {



}

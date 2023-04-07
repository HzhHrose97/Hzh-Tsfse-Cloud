package com.hzh.centre.openfeign;

import com.hzh.centre.handler.HzhTeamClientHandler;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 球队远程调用api接口
 *
 * @author Hou Zhonghu
 * @since 2022/7/7 15:10
 */
@FeignClient(value = "teamService",fallback = HzhTeamClientHandler.class)
public interface HzhTeamClinet {




}

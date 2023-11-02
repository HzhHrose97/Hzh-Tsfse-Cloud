package com.hzh.centre.openfeign;

import com.hzh.centre.handler.HzhTeamClientHandler;
import com.hzh.common.respone.MyResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 球队远程调用api接口
 *
 * @author Hou Zhonghu
 * @since 2022/7/7 15:10
 */
@FeignClient(value = "teamService",fallback = HzhTeamClientHandler.class)
public interface HzhTeamClinet {



    @RequestMapping(value = "/hzh-team/basketballTeamInfo/getAllBasketBallTeamInfo",method = RequestMethod.GET)
    MyResult getAllBashetballTeamInfo();
}

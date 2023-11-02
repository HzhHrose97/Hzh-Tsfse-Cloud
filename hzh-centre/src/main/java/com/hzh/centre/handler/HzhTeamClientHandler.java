package com.hzh.centre.handler;

import com.hzh.centre.openfeign.HzhTeamClinet;

import com.hzh.common.respone.MyResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: 赛事中心容错处理类
 * @Author: FXS) Hzh
 * @Date: 2023/3/31 17:19
 */
@Slf4j
public class HzhTeamClientHandler implements HzhTeamClinet {

    @Override
    public MyResult getAllBashetballTeamInfo() {
        log.error("球队中心调度发生熔断");
        return MyResult.FAILED("球队中心调度发生熔断");
    }
}

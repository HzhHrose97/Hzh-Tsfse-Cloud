package com.hzh.centre.handler;

import com.hzh.centre.openfeign.HzhCentreClient;
import com.hzh.centre.openfeign.HzhEventClient;
import com.hzh.common.respone.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description: 赛事中心容错处理类
 * @Author: FXS) Hzh
 * @Date: 2023/3/31 17:19
 */
@Slf4j
@Component
public class HzhCentreClientHandler implements HzhCentreClient {

    @Override
    public Result getAllChinaCity() {
        log.error("共享中心调度发生熔断");
        return Result.FAILED("共享中心调度发生熔断");
    }

    @Override
    public Result paginationGetAll() {
        log.error("共享中心调度发生熔断");
        return Result.FAILED("共享中心调度发生熔断");
    }
}

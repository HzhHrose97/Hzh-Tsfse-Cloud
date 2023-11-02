package com.hzh.centre.service.impl;

import com.hzh.centre.service.AsyncMessageService;
import com.hzh.common.mapper.mq.AsyncMessageMapper;
import com.hzh.common.pojo.centre.AsyncMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: FXS) Hzh
 * @Date: 2023/8/8 15:37
 */
@Service
public class AsyncMessageServiceImpl implements AsyncMessageService {

    @Resource
    private AsyncMessageMapper asyncMessageMapper;

    @Override
    public int addMessage(AsyncMessage asyncMessage) {

        int insert = asyncMessageMapper.insert(asyncMessage);
        return insert;
    }
}

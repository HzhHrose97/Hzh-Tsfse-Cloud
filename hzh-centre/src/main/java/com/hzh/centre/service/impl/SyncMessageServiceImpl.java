package com.hzh.centre.service.impl;

import com.hzh.centre.service.SyncMessageService;
import com.hzh.common.pojo.centre.SyncMessage;
import com.hzh.common.mapper.centre.SyncMessageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hzh
 * @since 2023-08-07
 */
@Service
public class SyncMessageServiceImpl extends ServiceImpl<SyncMessageMapper, SyncMessage> implements SyncMessageService {

    @Resource
    public  SyncMessageMapper syncMessageMapper;
    @Override
    public int addMessage(SyncMessage syncMessage) {
        try {
            int insert = syncMessageMapper.insert(syncMessage);
            return insert;
        }catch (Exception e) {
            throw new RuntimeException("addMessage Error",e);
        }
    }
}

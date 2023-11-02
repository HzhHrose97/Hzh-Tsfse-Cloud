package com.hzh.centre.service;

import com.hzh.common.pojo.centre.SyncMessage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hzh
 * @since 2023-08-07
 */
public interface SyncMessageService extends IService<SyncMessage> {

    int addMessage(SyncMessage syncMessage);
}

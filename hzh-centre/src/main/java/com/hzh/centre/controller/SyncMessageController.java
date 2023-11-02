package com.hzh.centre.controller;


import com.hzh.centre.service.SyncMessageService;
import com.hzh.common.pojo.centre.SyncMessage;
import com.hzh.common.respone.MyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 *  同步发送消息
 * </p>
 *
 * @author Hzh
 * @since 2023-08-07
 */
@Slf4j
@RestController
@Api(tags = "共享中心")
@RequestMapping("/syncMessage")
public class SyncMessageController {

    private static final String TOPIC = "NOCTIFICATION";

    @Resource
    public RocketMQTemplate rocketMQTemplate;

    @Resource
    public SyncMessageService syncMessageService;

    @PostMapping("/inform/synchronization")
    @ApiOperation("发布通知信息")
    @Transactional  // 添加事务注解
    public MyResult syncMessageProducer(@RequestBody SyncMessage syncMessage) {
        if (syncMessage == null) {
            return MyResult.FAILED("syncMessage is null");
        }
        try {
            int rows = syncMessageService.addMessage(syncMessage);
            if (rows >= 1) {
                // 同步发送消息（Sync Send）：在同步发送消息时，发送操作会阻塞当前线程，直到消息发送完成或超时。发送线程会一直等待，直到消息被成功发送或失败。
                rocketMQTemplate.syncSend(TOPIC, syncMessage);
                return MyResult.SUCCESS("SyncMessageProducer Success");
            } else {
                return MyResult.FAILED("Failed to add message to the database");
            }
        } catch (Exception e) {
            log.error("Error in syncMessageProducer", e);
            // 手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new RuntimeException("SyncMessageProducer error");
        }
    }


}


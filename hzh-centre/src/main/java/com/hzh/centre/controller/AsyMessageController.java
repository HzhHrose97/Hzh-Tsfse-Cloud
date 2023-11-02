package com.hzh.centre.controller;

import com.hzh.centre.service.AsyncMessageService;
import com.hzh.common.pojo.centre.AsyncMessage;
import com.hzh.common.respone.MyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;


/**
 * @Description: 异步发送消息
 * @Author: FXS) Hzh
 * @Date: 2023/8/8 15:06
 */
@Slf4j
@Service
@Api(tags = "共享中心")
@RestController("/AsyMessage")
public class AsyMessageController {

    public static final String TOPIC = "HHHH";
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private AsyncMessageService asyncMessageService;

    @PatchMapping("/inform/asynchronization")
    @ApiOperation("生产异步消息")
    @Transactional
    public MyResult syncMessageProducer(@RequestBody AsyncMessage asyncMessage) throws InterruptedException {
        if (asyncMessage == null) {
            return MyResult.FAILED("asyncMessage is null");
        }

        int i = asyncMessageService.addMessage(asyncMessage);
        final boolean[] rollbackTransaction = {false}; // 标志位，表示是否需要回滚事务

        if (i >= 1) {
            rocketMQTemplate.asyncSend("AsyncMessage",asyncMessage.getMessageBody() , new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("异步消息发送成功");
                }
                @Override
                public void onException(Throwable throwable) {
                    System.out.println("异步消息发送失败");
                }
            });

            // 等待异步消息发送完成
            Thread.sleep(1000);

            // 检查标志位，如果需要回滚，则手动触发事务回滚
            if (rollbackTransaction[0]) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                // 失败时返回结果
                return MyResult.FAILED("syncMessageProducer Error");
            } else {
                // 成功时返回结果
                return MyResult.SUCCESS("syncMessageProducer Success");
            }
        }
        return MyResult.SUCCESS("Async message producer started");
    }


}
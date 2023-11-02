package com.hzh.event.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
/**
 * @Description: 赛事中心消费通知消息
 * @Author: FXS) Hzh
 * @Date: 2023/8/7 17:10
 */
@Service
@RocketMQMessageListener(topic = "NOCTIFICATION", consumerGroup = "Consumer-Event")
public class SynMessageConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String messageContent) {
        // 处理接收到的消息逻辑
        System.out.println("同步消息Received message: " + messageContent);

        // 在这里执行处理逻辑，例如存储到数据库等

    }
}

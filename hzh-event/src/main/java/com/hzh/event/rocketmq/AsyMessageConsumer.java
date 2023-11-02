package com.hzh.event.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Description: 异步消息消费者
 * @Author: FXS) Hzh
 * @Date: 2023/8/8 17:04
 */
@Component
public class AsyMessageConsumer {

    @Value("${rocketmq.consumer.group}") // 在配置文件中配置消费者组名
    private String consumerGroup;

    @Value("${rocketmq.name-server}") // 在配置文件中配置NameServer地址
    private String namesrvAddr;

    @Value("${rocketmq.consumer.topic}") // 在配置文件中配置要消费的Topic
    private String topic;

    public void start() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        topic = "AsyncMessage";
        consumer.subscribe(topic, "*"); // 订阅Topic的全部消息

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(
                    List<MessageExt> messages,
                    ConsumeConcurrentlyContext context) {

                for (MessageExt message : messages) {
                    try {
                        String body = new String(message.getBody(), "UTF-8");
                        System.out.println("Received message: " + body);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}

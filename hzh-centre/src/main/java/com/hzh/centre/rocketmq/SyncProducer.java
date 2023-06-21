//package com.hzh.centre.rocketmq;
//
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//
///**
// * @Description: 测试同步发送消息
// *                  可靠性同步地发送方式使用的比较广泛，比如：重要的消息通知，短信通知。
// * @Author: FXS) Hzh
// * @Date: 2023/6/12 15:46
// */
//public class SyncProducer {
//    public static void main(String[] args) throws Exception {
//        // 实例化消息生产者Producer
//        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
//        // 设置NameServer的地址
//        producer.setNamesrvAddr("localhost:9876");
//        // 设置消息同步发送失败时的重试次数，默认为 2
//        producer.setRetryTimesWhenSendFailed(2);
//        // 设置消息发送超时时间，默认3000ms
//        producer.setSendMsgTimeout(3000);
//        // 启动Producer实例
//        producer.start();
//        for (int i = 0; i < 100; i++) {
//            // 创建消息，并指定Topic，Tag和消息体
//            Message msg = new Message("TopicTest" /* Topic */,
//                    "TagA" /* Tag */,
//                    ("Hello RocketMQ，这是一条同步消息" + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
//            );
//            // 发送消息到一个Broker
//            SendResult sendResult = producer.send(msg);
//            // 通过sendResult返回消息是否成功送达
//            System.out.printf("%s%n", sendResult);
//        }
//        // 如果不再发送消息，关闭Producer实例。
//        producer.shutdown();
//    }
//}

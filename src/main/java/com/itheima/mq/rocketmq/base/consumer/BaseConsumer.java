package com.itheima.mq.rocketmq.base.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class BaseConsumer {
    public static void main(String[] args) throws MQClientException {
        //1.创建消费者对象
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer();
        //2.指明nameservice
        consumer.setNamesrvAddr("192.168.200.128:9876");
        //3.订阅主题:topic和过消息用的tag表达式
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg : msgs){
                    System.out.println("消息收到");
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.启动消费者
        consumer.start();

    }
}

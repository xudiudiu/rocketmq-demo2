package com.itheima.mq.rocketmq.base.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class BaseProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //1.创建基本的消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //2.指定nameservice地址
        producer.setNamesrvAddr("192.168.200.128:9876");
        //3.启动生产者
        producer.start();
        //4.创建消息
        for (int i = 0; i < 10; i++) {
            //专门描述消息的对象
            Message message = new Message("topic","TagA","1".getBytes());
            //5.发送消息
            SendResult sendResult = producer.send(message);
            System.out.println(sendResult);
        }
        //关闭生产者
        producer.shutdown();
    }
}

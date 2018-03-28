package com.shop.learning.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fengli on 2018/3/28.
 */
@Component
@RabbitListener(queues = RabbitQueue.DATA_CHANG_QUEUE)
public class RabbitMQReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("从队列接收一条消息,对获取的信息进行解析 ："+message);



    }
}

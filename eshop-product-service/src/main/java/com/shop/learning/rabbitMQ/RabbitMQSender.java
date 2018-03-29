package com.shop.learning.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by fengli on 2018/3/27.MQ的生产者
 */
@Component
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String queue,String message){
        this.rabbitTemplate.convertAndSend(queue,message);
    }
}

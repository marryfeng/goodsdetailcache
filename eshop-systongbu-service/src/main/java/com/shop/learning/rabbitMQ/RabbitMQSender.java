package com.shop.learning.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fengli on 2018/3/29.
 */
@Component
public class RabbitMQSender {

   @Autowired
   private AmqpTemplate amqpTemplate;
    public void send(String queue,String message){
       this.amqpTemplate.convertAndSend(queue,message);

    }
}

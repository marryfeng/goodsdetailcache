package com.shop.learning.rabbitMQ;

/**
 * Created by fengli on 2018/3/27.
 * 接口是不能实例化的，所以在接口中的变量都是定义的常量，我们通常使用接口来定义常量
 */
public interface RabbitQueue {
    public static final String DATA_CHANG_QUEUE="data-change-queue";
}

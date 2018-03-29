package com.shop.learning.rabbitMQ;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shop.learning.feignService.ServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import springfox.documentation.spring.web.json.Json;

/**
 * Created by fengli on 2018/3/28.
 * 缓冲服务作为消费者，要接收MQ发送过来的消息，然后进行解析，然后根据解析的内容调用商品服务，获取到信息后将信息更新到Redis中
 */
@Component
@RabbitListener(queues = RabbitQueue.DATA_CHANG_QUEUE)
public class RabbitMQReceiver {

    @Autowired
    private ServiceFeign serviceFeign;
    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    public static Logger logger=LoggerFactory.getLogger(RabbitMQReceiver.class);

    @RabbitHandler
    public void process(String message){
        logger.info("获取MQ的消息，开始解析：");
        /*
        JSON.parseObject（String str）是将str转化为相应的JSONObject对象，
        其中str是“键值对”形式的json字符串，
        转化为JSONObject对象之后就可以使用其内置的方法，进行各种处理了。
        JSONObject就是解析后的json对象，之前是string类型的，现在是标准的json串
        */
       JSONObject jsonObject=JSONObject.parseObject(message);
       String dataType=jsonObject.getString("data_type");
       if (dataType.equals("brand")){
           //如果是品牌类型，则执行调用品牌的方法来更新内容
           processBrandDataChangeMessage(jsonObject);
       }else if(dataType.equals("category")){
           processCategoryDataChangeMessage(jsonObject);
       }else if(dataType.equals("productIntroduction")){
           processProductIntroductionDataChangeMessage(jsonObject);
       }else if(dataType.equals("productProperty")){
           processProductPropertyDataChangeMessage(jsonObject);
       }else if(dataType.equals("product")){
           processProductDataChangeMessage(jsonObject);
       }else if(dataType.equals("productSpecification")){
           processProductSpecificationChangeMessage(jsonObject);
       }

    }

    private void processProductSpecificationChangeMessage(JSONObject jsonObject) {
        Integer id= jsonObject.getInteger("id");
        //当类型是add或者update的时候，我们只需要根据id获取到product更新后的内容即可，因为这只是一个消息而已，内容以及改了，我们获取到最新的消息即可。
        //获取到的内容是一个json串，我们需要解析。
        String eventType=jsonObject.getString("event_type");
        if (eventType.equals("add")||eventType.equals("update")) {
            JSONObject jsonData = JSONObject.parseObject(serviceFeign.productSpecificationFeignFindByIdService(id));
            //获取到数据后更新到redis
            Jedis jedis= jedisPool.getResource();
            jedis.set("productSpecification_"+jsonData.get("id"),jsonData.toJSONString());
        }else if(eventType.equals("delete")){
            Jedis jedis= jedisPool.getResource();
            jedis.del("productSpecification_"+id);
        }
        rabbitMQSender.send(RabbitQueue.AGGRE_DATA_CHANGE_QUEUE,"{\"dim_type\":\"product\",\"id\":"+id+",\"productId\":"+jsonObject.getInteger("productId")+"}");

    }

    private void processProductDataChangeMessage(JSONObject jsonObject) {
        Integer id= jsonObject.getInteger("id");
        //当类型是add或者update的时候，我们只需要根据id获取到product更新后的内容即可，因为这只是一个消息而已，内容以及改了，我们获取到最新的消息即可。
        //获取到的内容是一个json串，我们需要解析。
        String eventType=jsonObject.getString("event_type");
        if (eventType.equals("add")||eventType.equals("update")) {
            JSONObject jsonData = JSONObject.parseObject(serviceFeign.productFeignFindByIdService(id));
            //获取到数据后更新到redis
            Jedis jedis= jedisPool.getResource();
            jedis.set("product_"+jsonData.get("id"),jsonData.toJSONString());
        }else if(eventType.equals("delete")){
            Jedis jedis= jedisPool.getResource();
            jedis.del("product_"+id);
        }
        rabbitMQSender.send(RabbitQueue.AGGRE_DATA_CHANGE_QUEUE,"{\"dim_type\":\"product\",\"id\":"+id+"}");


    }

    private void processProductPropertyDataChangeMessage(JSONObject jsonObject) {
        Integer id= jsonObject.getInteger("id");
        //当类型是add或者update的时候，我们只需要根据id获取到product更新后的内容即可，因为这只是一个消息而已，内容以及改了，我们获取到最新的消息即可。
        //获取到的内容是一个json串，我们需要解析。
        String eventType=jsonObject.getString("event_type");
        if (eventType.equals("add")||eventType.equals("update")) {
            JSONObject jsonData = JSONObject.parseObject(serviceFeign.productPropertyFeignFindByIdService(id));
            //获取到数据后更新到redis
            Jedis jedis= jedisPool.getResource();
            jedis.set("productProperty_"+jsonData.get("id"),jsonData.toJSONString());
        }else if(eventType.equals("delete")){
            Jedis jedis= jedisPool.getResource();
            jedis.del("productProperty_"+id);
        }
        rabbitMQSender.send(RabbitQueue.AGGRE_DATA_CHANGE_QUEUE,"{\"dim_type\":\"product\",\"id\":"+id+",\"productId\":" + jsonObject.getInteger("productId") + "}");


    }

    private void processProductIntroductionDataChangeMessage(JSONObject jsonObject) {
        Integer id= jsonObject.getInteger("id");
        //当类型是add或者update的时候，我们只需要根据id获取到product更新后的内容即可，因为这只是一个消息而已，内容以及改了，我们获取到最新的消息即可。
        //获取到的内容是一个json串，我们需要解析。
        String eventType=jsonObject.getString("event_type");
        if (eventType.equals("add")||eventType.equals("update")) {
            JSONObject jsonData = JSONObject.parseObject(serviceFeign.productIntroductionFeignFindByIdService(id));
            //获取到数据后更新到redis
            Jedis jedis= jedisPool.getResource();
            jedis.set("productIntroduction_"+jsonData.get("id"),jsonData.toJSONString());
        }else if(eventType.equals("delete")){
            Jedis jedis= jedisPool.getResource();
            jedis.del("productIntroduction_"+id);
        }
        rabbitMQSender.send(RabbitQueue.AGGRE_DATA_CHANGE_QUEUE,"{\"dim_type\":\"productIntroduction\",\"id\":"+id+",\"productId\":" + jsonObject.getInteger("productId") + "}");


    }

    private void processCategoryDataChangeMessage(JSONObject jsonObject) {
        Integer id= jsonObject.getInteger("id");
        //当类型是add或者update的时候，我们只需要根据id获取到product更新后的内容即可，因为这只是一个消息而已，内容以及改了，我们获取到最新的消息即可。
        //获取到的内容是一个json串，我们需要解析。
        String eventType=jsonObject.getString("event_type");
        if (eventType.equals("add")||eventType.equals("update")) {
            JSONObject jsonData = JSONObject.parseObject(serviceFeign.categoryFeignFindByIdService(id));
            //获取到数据后更新到redis
            Jedis jedis= jedisPool.getResource();
            jedis.set("category_"+jsonData.get("id"),jsonData.toJSONString());
        }else if(eventType.equals("delete")){
            Jedis jedis= jedisPool.getResource();
            jedis.del("brand_"+id);
        }
        rabbitMQSender.send(RabbitQueue.AGGRE_DATA_CHANGE_QUEUE,"{\"dim_type\":\"category\",\"id\":"+id+"}");

    }

    //品牌数据的获取
    private void processBrandDataChangeMessage(JSONObject jsonObject) {
       Integer id= jsonObject.getInteger("id");
       //当类型是add或者update的时候，我们只需要根据id获取到product更新后的内容即可，因为这只是一个消息而已，内容以及改了，我们获取到最新的消息即可。
        //获取到的内容是一个json串，我们需要解析。
        String eventType=jsonObject.getString("event_type");
        if (eventType.equals("add")||eventType.equals("update")) {
            JSONObject jsonData = JSONObject.parseObject(serviceFeign.brandFeignFindByIdService(id));
            //获取到数据后更新到redis
           Jedis jedis= jedisPool.getResource();
           jedis.set("brand_"+jsonData.get("id"),jsonData.toJSONString());
        }else if(eventType.equals("delete")){
           Jedis jedis= jedisPool.getResource();
           jedis.del("brand_"+id);
        }
        rabbitMQSender.send(RabbitQueue.AGGRE_DATA_CHANGE_QUEUE,"{\"dim_type\":\"brand\",\"id\":"+id+"}");


    }
}

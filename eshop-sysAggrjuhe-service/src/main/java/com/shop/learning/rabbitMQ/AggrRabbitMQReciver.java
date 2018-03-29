package com.shop.learning.rabbitMQ;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by fengli on 2018/3/29.
 * 数据聚合：从redis中读取数据，然后将数据聚合起来再次放入Reids中，因为数据一般都是多原子的，所以需要整合。
 */
@Component
@RabbitListener(queues = RabbitQueue.AGGRE_DATA_CHANGE_QUEUE)
public class AggrRabbitMQReciver {

    @Autowired
    private JedisPool  jedisPool;

    public  void process(String message){
    //自动生成返回值的快捷：ctrl+alt+V
        JSONObject jsonObject = JSONObject.parseObject(message);
        String dimType = jsonObject.getString("dim_type");
        if ("brand".equals(dimType)){
           processBrandDimDataChange(jsonObject);
        }else if("category".equals(dimType)){
            processCategoryDimDataChange(jsonObject);
        }else if("productIntroduction".equals(dimType)){
            processProductIntroduction(jsonObject);

        }else if("product".equals(dimType)){
            processProductDimDataChange(jsonObject);

        }

    }

    private void processProductDimDataChange(JSONObject jsonObject) {
        Integer id=jsonObject.getInteger("id");
        Jedis jedis = jedisPool.getResource();
        String productData = jedis.get("productIntroduction_" + id);
        if (productData!=null && !"".equals(productData)) {
            JSONObject productDataJson = JSONObject.parseObject(productData);
            String productProperty = jedis.get("productProperty_" + id);
            if (productProperty != null && !"".equals(productProperty)) {
                //向map中增加内容
                productDataJson.put("productProperty",JSONObject.parseObject(productProperty));
            }
            String productSpecification = jedis.get("productSpecification_" + id);
            if (productSpecification != null && !"".equals(productSpecification)) {
                //向map中增加内容
                productDataJson.put("productSpecification",JSONObject.parseObject(productSpecification));
            }

            jedis.set("dim_product"+id,productDataJson.toJSONString());
        }else{
            jedis.del("dim_product"+id);
        }


    }

    private void processProductIntroduction(JSONObject jsonObject) {
        Integer id=jsonObject.getInteger("id");
        Jedis jedis = jedisPool.getResource();
        String introductionData = jedis.get("productIntroduction_" + id);
        if (introductionData!=null && !"".equals(introductionData)){
            jedis.set("dim_productIntroduction"+id,introductionData);
        }else{
            jedis.del("dim_productIntroduction");
        }
    }

    private void processBrandDimDataChange(JSONObject jsonObject) {
        Integer id=jsonObject.getInteger("id");
        Jedis jedis = jedisPool.getResource();
        String brandData = jedis.get("brand_" + id);
        if (brandData!=null && !"".equals(brandData)){
            jedis.set("dim_brand"+id,brandData);
        }else{
            jedis.del("dim_brand");
        }
    }

    private void processCategoryDimDataChange(JSONObject jsonObject) {
        Integer id=jsonObject.getInteger("id");
        Jedis jedis = jedisPool.getResource();
        String categoryData = jedis.get("category_" + id);
        if (categoryData!=null && !"".equals(categoryData)){
            jedis.set("dim_category"+id,categoryData);
        }else{
            jedis.del("dim_category");
        }
    }


}

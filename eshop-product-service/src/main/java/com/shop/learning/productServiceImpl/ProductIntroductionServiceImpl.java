package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.ProductIntroduction;
import com.shop.learning.productMapper.ProductIntroductionMapper;
import com.shop.learning.producteService.ProductIntroductionService;
import com.shop.learning.rabbitMQ.RabbitMQSender;
import com.shop.learning.rabbitMQ.RabbitQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class ProductIntroductionServiceImpl implements ProductIntroductionService{

@Autowired
private ProductIntroductionMapper productIntroductionMapper;

@Autowired
private RabbitMQSender rabbitMQSender;

    @Override
    public void insertProductIntroduction(ProductIntroduction productIntroduction) {
        productIntroductionMapper.insertProductIntroduction(productIntroduction);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"productIntroduction\",\"id\":"+productIntroduction.getId()+",\"productId\":" + productIntroduction.getProduct_id() + "}");

    }

    @Override
    public void updateProductIntroduction(ProductIntroduction productIntroduction) {
        productIntroductionMapper.updateProductIntroduction(productIntroduction);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"productIntroduction\",\"id\":"+productIntroduction.getId()+",\"productId\":" + productIntroduction.getProduct_id() + "}");

    }

    @Override
    public void deleteProductIntroduction(Integer id) {
        ProductIntroduction productIntroduction=productIntroductionMapper.findById(id);

        productIntroductionMapper.deleteProductIntroduction(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"productIntroduction\",\"id\":"+id+",\"productId\":" + productIntroduction.getProduct_id() + "}");

    }

    @Override
    public List<ProductIntroduction> selectAll() {
        return productIntroductionMapper.selectAll();
    }

    @Override
    public ProductIntroduction findById(Integer id) {
        return productIntroductionMapper.findById(id);
    }
}

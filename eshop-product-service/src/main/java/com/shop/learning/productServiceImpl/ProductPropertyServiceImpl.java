package com.shop.learning.productServiceImpl;

import com.netflix.discovery.converters.Auto;
import com.shop.learning.productEntity.ProductProperty;
import com.shop.learning.productMapper.ProductPropertyMapper;
import com.shop.learning.producteService.ProductPropertyService;
import com.shop.learning.rabbitMQ.RabbitMQSender;
import com.shop.learning.rabbitMQ.RabbitQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class ProductPropertyServiceImpl implements ProductPropertyService {
    @Autowired
    private ProductPropertyMapper productPropertyMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insertProductProperty(ProductProperty productProperty) {
        productPropertyMapper.insertProductProperty(productProperty);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"productProperty\",\"id\":"+productProperty.getId()+",\"productId\":" + productProperty.getProduct_id()+ "}");

    }

    @Override
    public void updateProductProperty(ProductProperty productProperty) {
        productPropertyMapper.updateProductProperty(productProperty);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"productProperty\",\"id\":"+productProperty.getId()+",\"productId\":" + productProperty.getProduct_id() + "}");

    }

    @Override
    public void deleteProductProperty(Integer id) {
        ProductProperty productProperty=productPropertyMapper.findById(id);
        productPropertyMapper.deleteProductProperty(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"productProperty\",\"id\":"+id+",\"productId\":" + productProperty.getProduct_id() + "}");


    }

    @Override
    public List<ProductProperty> selectAll() {
        return productPropertyMapper.selectAll();
    }

    @Override
    public ProductProperty findById(Integer id) {
        return productPropertyMapper.findById(id);
    }
}

package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.ProductIntroduction;
import com.shop.learning.productEntity.ProductSpecification;
import com.shop.learning.productMapper.ProductIntroductionMapper;
import com.shop.learning.productMapper.ProductSpecificationMapper;
import com.shop.learning.producteService.ProductIntroductionService;
import com.shop.learning.producteService.ProductSpecificationService;
import com.shop.learning.rabbitMQ.RabbitMQSender;
import com.shop.learning.rabbitMQ.RabbitQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService{

    @Autowired
    private ProductSpecificationMapper productSpecificationMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;


    @Override
    public void insertProductSpecification(ProductSpecification productSpecification) {
        productSpecificationMapper.insertProductSpecification(productSpecification);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"productSpecification\",\"id\":"+productSpecification.getId()+",\"productId\":" + productSpecification.getProduct_id() + "}");


    }

    @Override
    public void updateProductSpecification(ProductSpecification productSpecification) {
        productSpecificationMapper.updateProductSpecification(productSpecification);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"productSpecification\",\"id\":"+productSpecification.getId()+",\"productId\":" + productSpecification.getProduct_id() + "}");

    }

    @Override
    public void deleteProductSpecification(Integer id) {
        ProductSpecification productSpecification=productSpecificationMapper.findById(id);
        productSpecificationMapper.deleteProductSpecification(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"productSpecification\",\"id\":"+id+",\"productId\":" +productSpecification.getProduct_id()+"}");


    }

    @Override
    public List<ProductSpecification> selectAll() {
        return productSpecificationMapper.selectAll();
    }

    @Override
    public ProductSpecification findById(Integer id) {
        return productSpecificationMapper.findById(id);
    }
}

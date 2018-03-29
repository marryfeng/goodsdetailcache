package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Product;
import com.shop.learning.productMapper.ProductMapper;
import com.shop.learning.producteService.ProductService;
import com.shop.learning.rabbitMQ.RabbitMQSender;
import com.shop.learning.rabbitMQ.RabbitQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"product\",\"id\":"+product.getId()+"}");


    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"product\",\"id\":"+product.getId()+"}");


    }

    @Override
    public void deleteProduct(Integer id) {
        productMapper.deleteProduct(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"product\",\"id\":"+id+"}");


    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }
}

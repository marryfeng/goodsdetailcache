package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Category;
import com.shop.learning.productEntity.Product;
import com.shop.learning.productMapper.CategoryMapper;
import com.shop.learning.producteService.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"category\",\"id\":"+category.getId()+"}");


    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"category\",\"id\":"+category.getId()+"}");

    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"category\",\"id\":"+id+"}");


    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }
}

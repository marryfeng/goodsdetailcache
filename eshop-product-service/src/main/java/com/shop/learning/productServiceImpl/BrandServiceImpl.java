package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Brand;
import com.shop.learning.productEntity.Category;
import com.shop.learning.productMapper.BrandMapper;
import com.shop.learning.productMapper.CategoryMapper;
import com.shop.learning.producteService.BrandService;
import com.shop.learning.producteService.CategoryService;
import com.shop.learning.rabbitMQ.RabbitMQSender;
import com.shop.learning.rabbitMQ.RabbitQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void insertBrand(Brand brand) {
        brandMapper.insertBrand(brand);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"add\",\"data_type\":\"brand\",\"id\":"+brand.getId()+"}");


}

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"update\",\"data_type\":\"brand\",\"id\":"+brand.getId()+"}");


    }

    @Override
    public void deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);
        rabbitMQSender.send(RabbitQueue.DATA_CHANG_QUEUE,"{\"event_type\":\"delete\",\"data_type\":\"brand\",\"id\":"+id+"}");

    }

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectById(id);
    }
}

package com.shop.learning.productServiceImpl;

import com.netflix.discovery.converters.Auto;
import com.shop.learning.productEntity.ProductProperty;
import com.shop.learning.productMapper.ProductPropertyMapper;
import com.shop.learning.producteService.ProductPropertyService;
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

    @Override
    public void insertProductProperty(ProductProperty productProperty) {
        productPropertyMapper.insertProductProperty(productProperty);
    }

    @Override
    public void updateProductProperty(ProductProperty productProperty) {
        productPropertyMapper.updateProductProperty(productProperty);
    }

    @Override
    public void deleteProductProperty(Integer id) {
        productPropertyMapper.deleteProductProperty(id);

    }

    @Override
    public List<ProductProperty> selectAll() {
        return productPropertyMapper.selectAll();
    }
}

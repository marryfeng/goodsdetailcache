package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Product;
import com.shop.learning.productMapper.ProductMapper;
import com.shop.learning.producteService.ProductService;
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

    @Override
    public void insertProduct(Product product) {
        productMapper.insertProduct(product);

    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);

    }

    @Override
    public void deleteProduct(Integer id) {
        productMapper.deleteProduct(id);

    }

    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }
}

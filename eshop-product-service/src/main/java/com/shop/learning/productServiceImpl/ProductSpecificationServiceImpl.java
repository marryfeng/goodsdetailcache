package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.ProductIntroduction;
import com.shop.learning.productEntity.ProductSpecification;
import com.shop.learning.productMapper.ProductIntroductionMapper;
import com.shop.learning.productMapper.ProductSpecificationMapper;
import com.shop.learning.producteService.ProductIntroductionService;
import com.shop.learning.producteService.ProductSpecificationService;
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


    @Override
    public void insertProductSpecification(ProductSpecification productSpecification) {
        productSpecificationMapper.insertProductSpecification(productSpecification);

    }

    @Override
    public void updateProductSpecification(ProductSpecification productSpecification) {
        productSpecificationMapper.updateProductSpecification(productSpecification);

    }

    @Override
    public void deleteProductSpecification(Integer id) {
        productSpecificationMapper.deleteProductSpecification(id);

    }

    @Override
    public List<ProductSpecification> selectAll() {
        return productSpecificationMapper.selectAll();
    }
}

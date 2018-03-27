package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.ProductIntroduction;
import com.shop.learning.productMapper.ProductIntroductionMapper;
import com.shop.learning.producteService.ProductIntroductionService;
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

    @Override
    public void insertProductIntroduction(ProductIntroduction productIntroduction) {
        productIntroductionMapper.insertProductIntroduction(productIntroduction);
    }

    @Override
    public void updateProductIntroduction(ProductIntroduction productIntroduction) {
        productIntroductionMapper.updateProductIntroduction(productIntroduction);
    }

    @Override
    public void deleteProductIntroduction(Integer id) {
        productIntroductionMapper.deleteProductIntroduction(id);
    }

    @Override
    public List<ProductIntroduction> selectAll() {
        return productIntroductionMapper.selectAll();
    }
}

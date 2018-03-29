package com.shop.learning.producteService;



import com.shop.learning.productEntity.ProductSpecification;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
public interface ProductSpecificationService {
    public void insertProductSpecification(ProductSpecification productSpecification);
    public void updateProductSpecification(ProductSpecification productSpecification);
    public void deleteProductSpecification(Integer id);
    public List<ProductSpecification> selectAll();

    ProductSpecification findById(Integer id);
}

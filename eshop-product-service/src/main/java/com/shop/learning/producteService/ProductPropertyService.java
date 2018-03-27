package com.shop.learning.producteService;

import com.shop.learning.productEntity.ProductProperty;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
public interface ProductPropertyService {
    public void insertProductProperty(ProductProperty productProperty);
    public void updateProductProperty(ProductProperty productProperty);
    public void deleteProductProperty(Integer id);
    public List<ProductProperty> selectAll();
}

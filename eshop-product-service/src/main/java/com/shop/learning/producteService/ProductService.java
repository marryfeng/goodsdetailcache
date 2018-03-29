package com.shop.learning.producteService;

import com.shop.learning.productEntity.Product;


import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
public interface ProductService {
    public void insertProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(Integer id);
    public List<Product> selectAll();

    Product findById(Integer id);
}

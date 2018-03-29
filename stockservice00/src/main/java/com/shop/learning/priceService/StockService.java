package com.shop.learning.priceService;

import com.shop.learning.stockEntity.ProductStock;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */

public interface StockService {

    public void insertProductStock(ProductStock stock);
    public void updateProductStock(ProductStock stock);
    public void deleteProductStock(Integer id);
    public List<ProductStock> selectAll();



}

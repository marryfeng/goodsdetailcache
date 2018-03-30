package com.shop.learning.stockService;

import com.shop.learning.priceEntity.ProductPrice;


import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */

public interface PriceService {

    public void insertProductPrice(ProductPrice price);
    public void updateProductPrice(ProductPrice Price);
    public void deleteProductPrice(Integer id);
    public List<ProductPrice> selectAll();


    ProductPrice findPriceByProductId(Integer id);
}

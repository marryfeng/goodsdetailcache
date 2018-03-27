package com.shop.learning.stockServiceImpl;

import com.shop.learning.priceEntity.ProductPrice;
import com.shop.learning.priceMapper.PriceMapper;
import com.shop.learning.stockService.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;
    @Override
    public void insertProductPrice(ProductPrice price) {
        priceMapper.insertProductPrice(price);

    }

    @Override
    public void updateProductPrice(ProductPrice price) {
        priceMapper.updateProductPrice(price);

    }

    @Override
    public void deleteProductPrice(Integer id) {
        priceMapper.deleteProductPrice(id);
    }

    @Override
    public List<ProductPrice> selectAll() {
        return priceMapper.selectAll();
    }
}

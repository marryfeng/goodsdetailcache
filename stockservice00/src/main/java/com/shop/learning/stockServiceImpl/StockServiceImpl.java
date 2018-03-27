package com.shop.learning.stockServiceImpl;

import com.shop.learning.stockEntity.ProductStock;
import com.shop.learning.stockMapper.StockMapper;
import com.shop.learning.stockService.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockMapper stockMapper;


    @Override
    public void insertProductStock(ProductStock stock) {
        stockMapper.insertProductStock(stock);

    }

    @Override
    public void updateProductStock(ProductStock stock) {
        stockMapper.updateProductStock(stock);

    }

    @Override
    public void deleteProductStock(Integer id) {
        stockMapper.deleteProductStock(id);

    }

    @Override
    public List<ProductStock> selectAll() {
        return stockMapper.selectAll();
    }
}

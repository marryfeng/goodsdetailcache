package com.shop.learning.priceServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.shop.learning.stockEntity.ProductStock;
import com.shop.learning.stockMapper.StockMapper;
import com.shop.learning.priceService.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private StockMapper stockMapper;


    @Override
    public void insertProductStock(ProductStock stock) {
        stockMapper.insertProductStock(stock);
        Jedis jedis=jedisPool.getResource();
        jedis.set("stockid"+stock.getId(), JSONObject.toJSONString(stock));

    }

    @Override
    public void updateProductStock(ProductStock stock) {
        stockMapper.updateProductStock(stock);
        Jedis jedis=jedisPool.getResource();
        jedis.set("stockid"+stock.getId(), JSONObject.toJSONString(stock));

    }

    @Override
    public void deleteProductStock(Integer id) {
        ProductStock productStock=stockMapper.selectById(id);
        stockMapper.deleteProductStock(id);
        Jedis jedis=jedisPool.getResource();
        jedis.del("stockid"+productStock.getId());

    }

    @Override
    public List<ProductStock> selectAll() {
        return stockMapper.selectAll();
    }
}

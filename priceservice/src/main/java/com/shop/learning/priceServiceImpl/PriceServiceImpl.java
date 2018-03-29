package com.shop.learning.priceServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.shop.learning.priceEntity.ProductPrice;
import com.shop.learning.priceMapper.PriceMapper;
import com.shop.learning.priceService.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private JedisPool jedisPool;
    @Override
    public void insertProductPrice(ProductPrice price) {
        priceMapper.insertProductPrice(price);
        Jedis jedis=jedisPool.getResource();
        jedis.set("priceid"+price.getId(), JSONObject.toJSONString(price));


    }

    @Override
    public void updateProductPrice(ProductPrice price) {
        priceMapper.updateProductPrice(price);
        Jedis jedis=jedisPool.getResource();
        jedis.set("priceid"+price.getId(), JSONObject.toJSONString(price));

    }

    @Override
    public void deleteProductPrice(Integer id) {
        ProductPrice productPrice=priceMapper.selectById(id);
        priceMapper.deleteProductPrice(id);
        Jedis jedis=jedisPool.getResource();
        jedis.del("priceid"+productPrice.getId());
    }

    @Override
    public List<ProductPrice> selectAll() {
        return priceMapper.selectAll();
    }
}

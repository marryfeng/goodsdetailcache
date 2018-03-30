package com.shop.learning.stockServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.shop.learning.priceEntity.ProductPrice;
import com.shop.learning.priceMapper.PriceMapper;
import com.shop.learning.stockService.PriceService;
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
        jedis.set("priceid"+price.getProduct_id() , JSONObject.toJSONString(price));


    }

    @Override
    public void updateProductPrice(ProductPrice price) {
        priceMapper.updateProductPrice(price);
        Jedis jedis=jedisPool.getResource();
        jedis.set("priceid"+price.getProduct_id(), JSONObject.toJSONString(price));

    }

    @Override
    public void deleteProductPrice(Integer id) {
        ProductPrice productPrice=priceMapper.selectById(id);
        priceMapper.deleteProductPrice(id);
        Jedis jedis=jedisPool.getResource();
        jedis.del("priceid"+productPrice.getProduct_id());
    }

    @Override
    public List<ProductPrice> selectAll() {

        return priceMapper.selectAll();
    }

    @Override
    public ProductPrice findPriceByProductId(Integer id) {
        //这里根据商品id商品的价格内容，我们需要先从Redis中查询，如果Redis没有，则从数据库查询
        Jedis jedis= jedisPool.getResource();
        String jsonData = jedis.get("priceid" + id);
        if (jsonData!=null &&!"".equals(jsonData)){
            JSONObject.parseObject(jsonData, ProductPrice.class);
            ProductPrice productPrice = JSONObject.parseObject(jsonData, ProductPrice.class);
            return  productPrice;
        }else{
            return priceMapper.findPriceByProductId(id);
        }


    }


}

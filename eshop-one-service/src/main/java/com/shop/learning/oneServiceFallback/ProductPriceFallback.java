package com.shop.learning.oneServiceFallback;


import com.shop.learning.OneServiceService.ProductPriceService;
import org.springframework.stereotype.Component;

/**
 * Created by fengli on 2018/3/30.
 */
@Component
public class ProductPriceFallback implements ProductPriceService{

    @Override
    public String pricecall(Integer id) {
        return "sorry：价格服务出现小故障，请谅解！";
    }
}

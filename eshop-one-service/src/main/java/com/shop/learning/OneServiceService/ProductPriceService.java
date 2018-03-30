package com.shop.learning.OneServiceService;

import com.shop.learning.oneServiceFallback.ProductPriceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fengli on 2018/3/30.
 */
@FeignClient(value = "priceservice",fallback =ProductPriceFallback.class)
@Service
public interface ProductPriceService {
    @RequestMapping(value = "/price/findPriceByProductId",method = RequestMethod.GET)
    public String pricecall(@RequestParam(value = "id") Integer id);
}

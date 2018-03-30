package com.shop.learning.OneServiceService;

import com.shop.learning.oneServiceFallback.ProductStockFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fengli on 2018/3/30.
 */
@FeignClient(value = "stockservice00",fallback = ProductStockFallback.class)
@Service
public interface ProductStockService {

    @RequestMapping(value = "/stock/findStockByProductId",method = RequestMethod.GET)
    public String stockcall(@RequestParam(value = "id") Integer id);


}

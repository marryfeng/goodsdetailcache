package com.shop.learning.oneServiceFallback;

import com.shop.learning.OneServiceService.ProductStockService;
import org.springframework.stereotype.Component;

/**
 * Created by fengli on 2018/3/30.
 */
@Component
public class ProductStockFallback implements ProductStockService {
    @Override
    public String stockcall(Integer id) {
        return "SORRY,库存服务出现故障！";
    }
}

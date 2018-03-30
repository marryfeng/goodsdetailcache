package com.shop.learning.oneserviceController;

import com.shop.learning.OneServiceService.ProductPriceService;
import com.shop.learning.OneServiceService.ProductStockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengli on 2018/3/30.
 */
@RestController
@Api(value = "oneservice服务调用测试")
@RequestMapping("/oneservice/")
public class OneServiceController {

    @Autowired
    private ProductPriceService productPriceService;
    @Autowired
    private ProductStockService productStockService;

    @RequestMapping(value = "price",method = RequestMethod.GET)
    @ApiOperation(value = "调用价格服务")
    public String callPrice(@RequestParam(value = "id") Integer id){
       return   productPriceService.pricecall(id);
    }

    @RequestMapping(value = "stock",method = RequestMethod.GET)
    @ApiOperation(value = "调用库存服务")
    public String stockPrice(@RequestParam(value = "id") Integer id){
        return   productStockService.stockcall(id);
    }


}

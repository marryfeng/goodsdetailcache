package com.shop.learning.priceController;

import com.shop.learning.priceEntity.ProductPrice;
import com.shop.learning.priceService.PriceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@RestController
@RequestMapping("/price/")
@Api("商品价格能测试")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品类目",tags = "添加商品类目的测试")
    public String insertPrice(@RequestBody ProductPrice price){
        priceService.insertProductPrice(price);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品类目查询",tags = "查询商品类目的测试")
    public List<ProductPrice> selectPrice(){
      return  priceService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品类目",tags = "更新商品类目的测试")
    public String updatePrice(@RequestBody ProductPrice price){
        priceService.updateProductPrice(price);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品类目",tags = "删除商品类目的测试")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "类目id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deletePrice(Integer id){
        priceService.deleteProductPrice(id);
        return "success";
    }



}

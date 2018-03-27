package com.shop.learning.stockController;

import com.shop.learning.stockEntity.ProductStock;
import com.shop.learning.stockService.StockService;
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
@RequestMapping("/stock/")
@Api("商品价格模块的功能测试")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品库存",tags = "添加商品库存的测试")
    public String insertstock(@RequestBody ProductStock stock){
        stockService.insertProductStock(stock);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品库存查询",tags = "查询商品库存的测试")
    public List<ProductStock> selectstock(){
      return  stockService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品库存",tags = "更新商品库存的测试")
    public String updatestock(@RequestBody ProductStock stock){
        stockService.updateProductStock(stock);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品库存",tags = "删除商品库存的测试")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "类目id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deletestock(Integer id){
        stockService.deleteProductStock(id);
        return "success";
    }



}

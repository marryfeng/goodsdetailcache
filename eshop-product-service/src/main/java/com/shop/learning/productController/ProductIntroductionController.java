package com.shop.learning.productController;

import com.shop.learning.productEntity.Product;
import com.shop.learning.productEntity.ProductIntroduction;
import com.shop.learning.producteService.ProductIntroductionService;
import com.shop.learning.producteService.ProductService;
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
@RequestMapping("/productIntroduction/")
@Api(value = "商品介绍模块的功能测试",tags = "商品介绍模块的功能测试")
public class ProductIntroductionController {

    @Autowired
    private ProductIntroductionService productIntroductionService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品")
    public String insertproductIntroduction(@RequestBody ProductIntroduction productIntroduction){
        productIntroductionService.insertProductIntroduction(productIntroduction);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品查询")
    public List<ProductIntroduction> selectproductIntroductionService(){
      return  productIntroductionService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品")
    public String updateproductIntroductionService(@RequestBody ProductIntroduction productIntroduction){
        productIntroductionService.updateProductIntroduction(productIntroduction);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品介绍")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "品牌id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deleteproductIntroductionService(Integer id){
        productIntroductionService.deleteProductIntroduction(id);
        return "success";
    }



}

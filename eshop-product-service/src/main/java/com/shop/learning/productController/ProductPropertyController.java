package com.shop.learning.productController;


import com.shop.learning.productEntity.ProductProperty;
import com.shop.learning.producteService.ProductPropertyService;
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
@RequestMapping("/ProductProperty/")
@Api(value = "商品属性模块的功能测试",tags = "商品属性模块的功能测试")
public class ProductPropertyController {

    @Autowired
    private ProductPropertyService productPropertyService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品属性")
    public String insertProductProperty(@RequestBody ProductProperty productProperty){
        productPropertyService.insertProductProperty(productProperty);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品属性查询")
    public List<ProductProperty> selectProductProperty(){
      return  productPropertyService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品属性")
    public String updateProductProperty(@RequestBody ProductProperty productProperty){
        productPropertyService.updateProductProperty(productProperty);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品属性品牌")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "品牌id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deleteProductProperty(Integer id){
        productPropertyService.deleteProductProperty(id);
        return "success";
    }



}

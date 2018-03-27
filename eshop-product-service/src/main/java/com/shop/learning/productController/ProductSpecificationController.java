package com.shop.learning.productController;

import com.shop.learning.productEntity.Product;
import com.shop.learning.productEntity.ProductSpecification;
import com.shop.learning.producteService.ProductService;
import com.shop.learning.producteService.ProductSpecificationService;
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
@RequestMapping("/ProductSpecification/")
@Api(value = "商品规格模块的功能测试",tags = "商品规格模块的功能测试")
public class ProductSpecificationController {

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品规格")
    public String insertProductSpecification(@RequestBody ProductSpecification productSpecification){
        productSpecificationService.insertProductSpecification(productSpecification);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品规格查询")
    public List<ProductSpecification> selectProductSpecification(){
      return  productSpecificationService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品规格")
    public String updateProductSpecification(@RequestBody ProductSpecification productSpecification){
        productSpecificationService.updateProductSpecification(productSpecification);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品规格品牌")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "品牌id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deleteProductSpecification(Integer id){
        productSpecificationService.deleteProductSpecification(id);
        return "success";
    }



}

package com.shop.learning.productController;

import com.shop.learning.productEntity.Brand;
import com.shop.learning.productEntity.Product;
import com.shop.learning.producteService.BrandService;
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
@RequestMapping("/product/")
@Api(value = "商品模块的功能测试",tags = "商品模块的功能测试" )
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品")
    public String insertProduct(@RequestBody Product product){
        productService.insertProduct(product);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品查询")
    public List<Product> selectProduct(){
      return  productService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品")
    public String updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品品牌")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "品牌id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deleteProduct(Integer id){
        productService.deleteProduct(id);
        return "success";
    }



}

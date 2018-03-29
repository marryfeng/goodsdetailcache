package com.shop.learning.productController;

import com.shop.learning.productEntity.Brand;
import com.shop.learning.productEntity.Category;
import com.shop.learning.producteService.BrandService;
import com.shop.learning.producteService.CategoryService;
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
@RequestMapping("/brand")
@Api(value = "商品品牌模块的功能测试",tags ="商品品牌模块的功能测试")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品品牌")
    public String insertBrand(@RequestBody Brand brand){
        brandService.insertBrand(brand);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品品牌查询")
    public List<Brand> selectBrand(){
      return  brandService.selectAll();
    }
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ApiOperation(value = "商品品牌查询")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "id",name = "id",dataType = "Integer",paramType = "form")
    )
    public Brand findById(Integer id){
        return  brandService.findById(id);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品品牌")
    public String updateBrand(@RequestBody Brand brand){
        brandService.updateBrand(brand);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品品牌")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "品牌id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deleteBrand(Integer id){
        brandService.deleteBrand(id);
        return "success";
    }



}

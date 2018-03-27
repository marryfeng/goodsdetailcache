package com.shop.learning.productController;

import com.shop.learning.productEntity.Category;
import com.shop.learning.producteService.CategoryService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@RestController
@RequestMapping("/category/")
@Api(value = "商品分类模块的功能测试",tags = "商品分类模块功能测试")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ApiOperation(value = "商品类目测试")
    public String insertCategory(@RequestBody Category category){
        categoryService.insertCategory(category);
        return "success";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ApiOperation(value = "商品类目查询" )
    public List<Category> selectCategory(){
      return  categoryService.selectAll();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "更新商品类目")
    public String updateCategory(@RequestBody Category category){
        categoryService.updateCategory(category);
        return "success";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除商品类目")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "类目id",name = "id",dataType = "Integer",required =true,paramType ="form")
    )
    public String deleteCategory(Integer id){
        categoryService.deleteCategory(id);
        return "success";
    }



}

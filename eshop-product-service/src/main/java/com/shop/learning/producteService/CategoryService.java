package com.shop.learning.producteService;

import com.shop.learning.productEntity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */

public interface CategoryService {

    public void insertCategory(Category category);
    public void updateCategory(Category category);
    public void deleteCategory(Integer id);
    public List<Category> selectAll();



}

package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Category;
import com.shop.learning.productEntity.Product;
import com.shop.learning.productMapper.CategoryMapper;
import com.shop.learning.producteService.CategoryService;
import com.shop.learning.producteService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);

    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCategory(id);

    }

    @Override
    public List<Category> selectAll() {
        return categoryMapper.selectAll();
    }
}

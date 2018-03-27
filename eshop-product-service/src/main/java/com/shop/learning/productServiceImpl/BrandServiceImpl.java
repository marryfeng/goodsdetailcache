package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Brand;
import com.shop.learning.productEntity.Category;
import com.shop.learning.productMapper.BrandMapper;
import com.shop.learning.productMapper.CategoryMapper;
import com.shop.learning.producteService.BrandService;
import com.shop.learning.producteService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void insertBrand(Brand brand) {
        brandMapper.insertBrand(brand);

    }

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);

    }

    @Override
    public void deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);

    }

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }
}

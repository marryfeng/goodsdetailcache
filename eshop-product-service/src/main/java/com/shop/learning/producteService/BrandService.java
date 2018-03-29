package com.shop.learning.producteService;

import com.shop.learning.productEntity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */

public interface BrandService {

    public void insertBrand(Brand brand);
    public void updateBrand(Brand brand);
    public void deleteBrand(Integer id);
    public List<Brand> selectAll();
    Brand findById(Integer id);



}

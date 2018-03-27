package com.shop.learning.producteService;

import com.shop.learning.productEntity.ProductIntroduction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */

public interface ProductIntroductionService {
    public void insertProductIntroduction(ProductIntroduction productIntroduction);
    public void updateProductIntroduction(ProductIntroduction productIntroduction);
    public void deleteProductIntroduction(Integer id);
    public List<ProductIntroduction> selectAll();
}

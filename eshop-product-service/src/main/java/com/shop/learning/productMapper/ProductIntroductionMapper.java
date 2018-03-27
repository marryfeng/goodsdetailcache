package com.shop.learning.productMapper;

import com.shop.learning.productEntity.ProductIntroduction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Mapper
public interface ProductIntroductionMapper {
    @Insert("insert into product_introduction(content,product_id) values(#{content},#{product_id})")
    public void insertProductIntroduction(ProductIntroduction ProductIntroduction);
    @Update("update  product_introduction set content=#{content},product_id=#{product_id} where id=#{id}")
    public void updateProductIntroduction(ProductIntroduction ProductIntroduction);
    @Delete("delete from product_introduction where id=#{id}")
    public void deleteProductIntroduction(Integer id);
    @Select("select * from product_introduction")
    public List<ProductIntroduction> selectAll();
}

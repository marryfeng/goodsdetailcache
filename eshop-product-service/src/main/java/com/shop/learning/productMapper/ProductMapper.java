package com.shop.learning.productMapper;

import com.shop.learning.productEntity.Brand;
import com.shop.learning.productEntity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Mapper
@Repository
public interface ProductMapper {

   @Insert("insert into product(name,category_id,brand_id) values(#{name},#{category_id},#{brand_id})")
    public void insertProduct(Product product);
   @Update("update product set name=#{name},category_id=#{category_id},brand_id=#{brand_id} where id=#{id}")
    public void updateProduct(Product product);
   @Delete("delete from product where id=#{id}")
    public void deleteProduct(Integer id);
   @Select("select * from product")
    public List<Product> selectAll();

    @Select("select * from product where id=#{id}")
    Product findById(Integer id);
}

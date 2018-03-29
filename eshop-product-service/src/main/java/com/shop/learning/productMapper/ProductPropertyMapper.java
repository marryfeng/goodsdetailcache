package com.shop.learning.productMapper;

import com.shop.learning.productEntity.Product;
import com.shop.learning.productEntity.ProductProperty;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Mapper
@Repository
public interface ProductPropertyMapper {
    @Insert("insert into product_property(name,valued,product_id) values(#{name},#{valued},#{product_id})")
    public void insertProductProperty(ProductProperty productProperty);
    @Update("update  product_property set name=#{name},valued=#{valued} where id=#{id} and  product_id=#{product_id}")
    public void updateProductProperty(ProductProperty productProperty);
    @Delete("delete from product_property where id=#{id}")
    public void deleteProductProperty(Integer id);
    @Select("select * from product_property")
    public List<ProductProperty> selectAll();
    @Select("select * from product_property where id=#{id}")
    ProductProperty findById(Integer id);
}

package com.shop.learning.productMapper;

import com.shop.learning.productEntity.Product;
import com.shop.learning.productEntity.ProductProperty;
import com.shop.learning.productEntity.ProductSpecification;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/27.
 */
@Mapper
@Repository
public interface ProductSpecificationMapper {
    @Insert("insert into product_specification(name,valued,product_id) values(#{name},#{valued},#{product_id})")
    public void insertProductSpecification(ProductSpecification ProductSpecification);
    @Update("update  product_specification set name=#{name},valued=#{valued} where id=#{id} and  product_id=#{product_id}")
    public void updateProductSpecification(ProductSpecification ProductSpecification);
    @Delete("delete from product_specification where id=#{id}")
    public void deleteProductSpecification(Integer id);
    @Select("select * from product_specification")
    public List<ProductSpecification> selectAll();
    @Select("select * from product_specification where id=#{id}")
    ProductSpecification findById(Integer id);
}

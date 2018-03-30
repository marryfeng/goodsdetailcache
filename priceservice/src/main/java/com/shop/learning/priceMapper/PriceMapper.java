package com.shop.learning.priceMapper;

import com.shop.learning.priceEntity.ProductPrice;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Mapper
@Repository
public interface PriceMapper {

   @Insert("insert into product_price(valued,product_id) values(#{valued},#{product_id})")
    public void insertProductPrice(ProductPrice productprice);
   @Update("update product_price set valued=#{valued},product_id=#{product_id} where id=#{id}")
    public void updateProductPrice(ProductPrice productprice);
   @Delete("delete from product_price where id=#{id}")
    public void deleteProductPrice(Integer id);
   @Select("select * from product_price")
    public List<ProductPrice> selectAll();

    @Select("select * from product_price where id=#{id}")
    ProductPrice selectById(Integer id);
    @Select("select * from product_price where product_id=#{id}")
    ProductPrice findPriceByProductId(Integer id);
}

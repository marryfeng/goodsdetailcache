package com.shop.learning.stockMapper;

import com.shop.learning.stockEntity.ProductStock;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Mapper
@Repository
public interface StockMapper {

   @Insert("insert into product_stock(valued,product_id) values(#{valued},#{product_id})")
    public void insertProductStock(ProductStock ProductStock);
   @Update("update product_stock set valued=#{valued},product_id=#{product_id} where id=#{id}")
    public void updateProductStock(ProductStock ProductStock);
   @Delete("delete from product_stock where id=#{id}")
    public void deleteProductStock(Integer id);
   @Select("select * from product_stock")
    public List<ProductStock> selectAll();
    @Select("select * from product_stock where id=#{id}")
    ProductStock selectById(Integer id);
    @Select("select * from product_stock where product_id=#{id}")
    ProductStock findStockByProductId(Integer id);
}

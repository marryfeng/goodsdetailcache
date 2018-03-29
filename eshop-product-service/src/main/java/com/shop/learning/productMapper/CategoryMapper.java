package com.shop.learning.productMapper;

import com.shop.learning.productEntity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Mapper
@Repository
public interface CategoryMapper {

   @Insert("insert into category(name,description) values(#{name},#{description})")
    public void insertCategory(Category category);
   @Update("update category set name=#{name},description=#{description} where id=#{id}")
    public void updateCategory(Category category);
   @Delete("delete from category where id=#{id}")
    public void deleteCategory(Integer id);
   @Select("select * from category")
    public List<Category> selectAll();

    @Select("select * from category where id=#{id}")
    Category findById(Integer id);
}

package com.shop.learning.productMapper;

import com.shop.learning.productEntity.Brand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengli on 2018/3/26.
 */
@Mapper
@Repository
public interface BrandMapper {

   @Insert("insert into brand(name,description) values(#{name},#{description})")
    public void insertBrand(Brand brand);
   @Update("update brand set name=#{name},description=#{description} where id=#{id}")
    public void updateBrand(Brand brand);
   @Delete("delete from brand where id=#{id}")
    public void deleteBrand(Integer id);
   @Select("select * from brand")
    public List<Brand> selectAll();

    @Select("select * from brand where id=#{id}")
    Brand selectById(Integer id);
}

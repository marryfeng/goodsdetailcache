package com.shop.learning.productMapper;

import com.shop.learning.productEntity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by fengli on 2018/3/24.
 */
@Mapper
public interface CacheMapper {


    @Select("select * from user")
    List<Demo> selectall();
}

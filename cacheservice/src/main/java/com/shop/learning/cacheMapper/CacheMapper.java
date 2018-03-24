package com.shop.learning.cacheMapper;

import com.shop.learning.cacheEntity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by fengli on 2018/3/24.
 */
@Mapper
public interface CacheMapper {


    @Select("select * from test01")
    List<Demo> selectall();
}

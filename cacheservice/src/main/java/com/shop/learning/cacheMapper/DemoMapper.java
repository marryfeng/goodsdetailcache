package com.shop.learning.cacheMapper;

import com.shop.learning.cacheEntity.Demo;

import java.util.List;

/**
 * Created by fengli on 2018/3/23.
 */

public interface DemoMapper {

    //@Select("select * from test01")
   List<Demo> select();
}

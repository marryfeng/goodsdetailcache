package com.shop.learning.cacheServiceImpl;

import com.netflix.discovery.converters.Auto;
import com.shop.learning.cacheEntity.Demo;
import com.shop.learning.cacheMapper.CacheMapper;
import com.shop.learning.cacheService.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/23.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private CacheMapper cacheMapper;

    @Override
    public List<Demo> getDetail() {
        return cacheMapper.selectall();
    }
}

package com.shop.learning.productServiceImpl;

import com.shop.learning.productEntity.Demo;
import com.shop.learning.productMapper.CacheMapper;
import com.shop.learning.producteService.DemoService;
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

package com.shop.learning.cacheService;

import com.shop.learning.cacheEntity.Demo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fengli on 2018/3/23.
 */
public interface DemoService {
    List<Demo> getDetail();

}

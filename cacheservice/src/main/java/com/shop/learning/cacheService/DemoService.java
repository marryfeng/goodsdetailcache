package com.shop.learning.cacheService;

import com.shop.learning.cacheEntity.Demo;
import org.springframework.stereotype.Service;

/**
 * Created by fengli on 2018/3/23.
 */
@Service
public interface DemoService {
    Demo getDetail();

}

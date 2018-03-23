package com.shop.learning.cacheController;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengli on 2018/3/23.
 */
@RestController
@Api(tags = "ceshi")
public class DemoController {

    @GetMapping("/test")
    public String select(){
        return null;
    }


}

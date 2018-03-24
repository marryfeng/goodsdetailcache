package com.shop.learning.cacheController;

import com.shop.learning.cacheEntity.Demo;
import com.shop.learning.cacheService.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fengli on 2018/3/23.
 */
@RestController
@Api(tags = "ceshi")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    @ApiOperation(value = "测试",tags = "测试连接数据库")
    public List<Demo> select(){

        return demoService.getDetail();
    }


}

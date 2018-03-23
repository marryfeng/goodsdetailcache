package com.shop.learning.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengli on 2018/3/23.
 */
@RestController
@Api("swagger2的测试")
public class TestController {

   @GetMapping("/hi")
   @ApiOperation(value = "api测试",tags = "api测试")
    public String hi(){
        return "hi,swagger";
    }
}

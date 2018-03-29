package com.shop.learning.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fengli on 2018/3/29.
 */
@Repository
@FeignClient(value = "eshop-product-service")
public interface ServiceFeign {
    @RequestMapping(value = "brand/findById",method = RequestMethod.GET)
    public String brandFeignFindByIdService(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "categpry/findById",method = RequestMethod.GET)
    public String categoryFeignFindByIdService(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "product/findById",method = RequestMethod.GET)
    public String productFeignFindByIdService(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "productIntroduction/findById",method = RequestMethod.GET)
    public String productIntroductionFeignFindByIdService(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "productProperty/findById",method = RequestMethod.GET)
    public String productPropertyFeignFindByIdService(@RequestParam(value = "id") Integer id);
    @RequestMapping(value = "productSpecification/findById",method = RequestMethod.GET)
    public String productSpecificationFeignFindByIdService(@RequestParam(value = "id") Integer id);

}

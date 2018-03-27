package com.shop.learning.productEntity;

import java.io.Serializable;

/**
 * Created by fengli on 2018/3/26.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -5753861477248769818L;
    private Integer id;
    private String name;
    private Integer category_id;
    private Integer brand_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }
}

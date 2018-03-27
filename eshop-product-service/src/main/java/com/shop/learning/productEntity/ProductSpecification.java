package com.shop.learning.productEntity;

import java.io.Serializable;

/**
 * Created by fengli on 2018/3/26.
 */
public class ProductSpecification implements Serializable{

    private static final long serialVersionUID = -758024034011666177L;
    private Integer id;
    private String name;
    private String valued;
    private Integer product_id;

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


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getValued() {
        return valued;
    }

    public void setValued(String valued) {
        this.valued = valued;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}

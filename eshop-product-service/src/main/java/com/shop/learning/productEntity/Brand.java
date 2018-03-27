package com.shop.learning.productEntity;

import java.io.Serializable;

/**
 * Created by fengli on 2018/3/26.
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = 8314558656661525658L;
    private Integer id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

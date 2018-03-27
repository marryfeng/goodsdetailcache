package com.shop.learning.productEntity;

import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by fengli on 2018/3/26.
 */
public class ProductIntroduction implements Serializable {

    private static final long serialVersionUID = -1218223524940687258L;
    private Integer id;
    private String content;
    private Integer product_id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}

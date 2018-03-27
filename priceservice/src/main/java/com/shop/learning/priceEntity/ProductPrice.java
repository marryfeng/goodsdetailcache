package com.shop.learning.priceEntity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by fengli on 2018/3/27.
 */
public class ProductPrice implements Serializable {

    private static final long serialVersionUID = 6216142005983362163L;
    private Integer id;
    private BigDecimal valued;
    private Integer product_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValued() {
        return valued;
    }

    public void setValued(BigDecimal valued) {
        this.valued = valued;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}

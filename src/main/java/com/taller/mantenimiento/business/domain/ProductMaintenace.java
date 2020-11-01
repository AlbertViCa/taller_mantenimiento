package com.taller.mantenimiento.business.domain;

import java.math.BigDecimal;

public class ProductMaintenace {

    private Integer productId;
    private double total;
    private boolean active;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

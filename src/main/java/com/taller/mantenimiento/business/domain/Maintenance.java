package com.taller.mantenimiento.business.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Maintenance {

    private Integer maintenanceId;
    private List<ProductMaintenace> products;
    private LocalDateTime date;
    private boolean active;

    public Integer getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(Integer maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public List<ProductMaintenace> getProducts() {
        return products;
    }

    public void setProducts(List<ProductMaintenace> products) {
        this.products = products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

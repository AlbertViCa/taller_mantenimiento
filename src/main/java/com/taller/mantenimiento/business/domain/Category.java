package com.taller.mantenimiento.business.domain;

/**
 *
 * Implementación del patrón Datta Mapper.
 *
 * */

public class Category {

    private Integer categoryId;
    private String description;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

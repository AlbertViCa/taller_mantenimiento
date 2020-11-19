package com.taller.mantenimiento.business.domain.dto;

import com.taller.mantenimiento.business.domain.Product;
import com.taller.mantenimiento.persisntence.crud.ProductoCrudRepository;
import com.taller.mantenimiento.persisntence.dao.data.base.ProductoDBRepository;
import com.taller.mantenimiento.persisntence.entity.Producto;

public class ProductoDTO {

    ProductoDBRepository productoDBRepository = new ProductoDBRepository();

    public void getProductData(String marca, String modelo, String descripcion, int categoria){
        Producto producto = new Producto(marca, modelo, descripcion, categoria);
        productoDBRepository.saveData(producto);
    }

}

package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.crud.ProductoCrudRepository;
import com.taller.mantenimiento.persisntence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository{

    @Autowired
    ProductoCrudRepository productoCrudRepository;

    public Producto guardar(Producto producto){
        return producto = productoCrudRepository.save(producto);
    }
}

package com.taller.mantenimiento.persisntence.dao;

import com.taller.mantenimiento.persisntence.crud.ProductoCrudRepository;
import com.taller.mantenimiento.persisntence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}

package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository{

    @Autowired
    ProductoCrudRepository productoCrudRepository;


}

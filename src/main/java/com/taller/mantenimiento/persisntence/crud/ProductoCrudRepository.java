package com.taller.mantenimiento.persisntence.crud;

import com.taller.mantenimiento.persisntence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


//Crear QueryMethods//
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByIdCategoriaOrderByMarcaAsc(int idCaregoria);
}

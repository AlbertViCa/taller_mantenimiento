package com.taller.mantenimiento.persisntence.crud;

import com.taller.mantenimiento.persisntence.entity.Mantenimiento;
import com.taller.mantenimiento.persisntence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

}

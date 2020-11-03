package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.crud.MantenimientoProductoCrudRepository;
import com.taller.mantenimiento.persisntence.entity.MantenimientoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MantenimientoProductoRepository {

    @Autowired
    MantenimientoProductoCrudRepository mantenimientoCrudRepository;

    public MantenimientoProducto guardar(MantenimientoProducto mantenimientoProducto){
        return mantenimientoProducto = mantenimientoCrudRepository.save(mantenimientoProducto);
    }
}

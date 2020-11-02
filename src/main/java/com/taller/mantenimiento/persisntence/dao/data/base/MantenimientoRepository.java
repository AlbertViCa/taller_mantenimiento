package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.crud.MantenimientoCrudRepository;
import com.taller.mantenimiento.persisntence.entity.Mantenimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MantenimientoRepository {

    @Autowired
    private MantenimientoCrudRepository mantenimientoCrudRepository;

    public Mantenimiento guardar(Mantenimiento mantenimiento){
        return mantenimiento = mantenimientoCrudRepository.save(mantenimiento);
    }
}

package com.taller.mantenimiento.persisntence.crud;

import com.taller.mantenimiento.persisntence.entity.MantenimientoProducto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MantenimientoProductoCrudRepository extends CrudRepository<MantenimientoProducto, Integer> {
    Optional<List<MantenimientoProducto>> findById(int id);
}

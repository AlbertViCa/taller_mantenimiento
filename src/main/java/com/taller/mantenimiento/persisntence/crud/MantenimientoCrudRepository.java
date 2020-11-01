package com.taller.mantenimiento.persisntence.crud;

import com.taller.mantenimiento.persisntence.entity.Mantenimiento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MantenimientoCrudRepository extends CrudRepository<Mantenimiento, Integer> {
    Optional<List<Mantenimiento>> findByIdMantenimiento(int idMantenimiento);
}

package com.taller.mantenimiento.persisntence.dao;

import com.taller.mantenimiento.business.domain.Maintenance;
import com.taller.mantenimiento.business.domain.repository.MaintenanceRepository;
import com.taller.mantenimiento.persisntence.crud.MantenimientoCrudRepository;
import com.taller.mantenimiento.persisntence.entity.Mantenimiento;
import com.taller.mantenimiento.persisntence.mapper.MaintenanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MantenimientoRepository implements MaintenanceRepository {

    @Autowired
    private MantenimientoCrudRepository mantenimientoCrudRepository;

    @Autowired
    private MaintenanceMapper mapper;

    @Override
    public List<Maintenance> getAll() {
        return mapper.toMaintenances((List<Mantenimiento>) mantenimientoCrudRepository.findAll());
    }

    @Override
    public Optional<List<Maintenance>> getById(int maintenanceId) {
        return mantenimientoCrudRepository.findByIdMantenimiento(maintenanceId)
                .map(mantenimientos -> mapper.toMaintenances(mantenimientos));
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        Mantenimiento mantenimiento = mapper.toMantenimiento(maintenance);
        mantenimiento.getProductos().forEach(producto -> producto.setMantenimiento(mantenimiento));

        return mapper.toMaintenance(mantenimientoCrudRepository.save(mantenimiento));
    }
}

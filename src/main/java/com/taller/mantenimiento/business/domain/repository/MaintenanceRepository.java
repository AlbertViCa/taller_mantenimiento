package com.taller.mantenimiento.business.domain.repository;

import com.taller.mantenimiento.business.domain.Maintenance;

import java.util.List;
import java.util.Optional;

public interface MaintenanceRepository {
    List<Maintenance> getAll();
    Optional<List<Maintenance>> getById(int idMaintenance);
    Maintenance save(Maintenance maintenance);
}

package com.taller.mantenimiento.business.domain.service;

import com.taller.mantenimiento.business.domain.Maintenance;
import com.taller.mantenimiento.business.domain.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    @Autowired
    private MaintenanceRepository maintenanceRepository;

    public List<Maintenance> getAll(){
        return maintenanceRepository.getAll();
    }

    public Optional<List<Maintenance>> getByClientId(String clientId){
        return maintenanceRepository.getByCleintId(clientId);
    }

    public Maintenance save(Maintenance maintenance){
        return maintenanceRepository.save(maintenance);
    }
}

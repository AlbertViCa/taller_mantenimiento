package com.taller.mantenimiento.web.controller;

import com.taller.mantenimiento.business.domain.Maintenance;
import com.taller.mantenimiento.business.domain.service.MaintenanceService;
import com.taller.mantenimiento.persisntence.mapper.MaintenanceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private MaintenanceMapper mapper;

    @GetMapping("/all")
    public ResponseEntity<List<Maintenance>> getAll(){
        return new ResponseEntity<>(maintenanceService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Maintenance>> getByClient(@PathVariable("id") String clienteId){
        return maintenanceService.getByClientId(clienteId)
                .map(maintenances -> new ResponseEntity<>(maintenances, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

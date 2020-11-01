package com.taller.mantenimiento.persisntence.mapper;


import com.taller.mantenimiento.business.domain.Maintenance;
import com.taller.mantenimiento.persisntence.entity.Mantenimiento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMaintenanceMapper.class})
public interface MaintenanceMapper {

    @Mappings({
            @Mapping(source = "idMantenimiento", target = "maintenanceId"),
            @Mapping(source = "productos", target = "products"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "estado", target = "active"),

    })
    Maintenance toMaintenance(Mantenimiento mantenimiento);
    List<Maintenance> toMaintenances(List<Mantenimiento> mantenimientoList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true),
            @Mapping(target = "idCliente", ignore = true)
    })
    Mantenimiento toMantenimiento(Maintenance maintenance);
}

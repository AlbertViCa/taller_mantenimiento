package com.taller.mantenimiento.persisntence.mapper;


import com.taller.mantenimiento.business.domain.ProductMaintenace;
import com.taller.mantenimiento.persisntence.entity.MantenimientoProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductMaintenanceMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "estado", target = "active")
    })
    ProductMaintenace toProductMaintencance(MantenimientoProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "mantenimiento", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idMantenimiento", ignore = true),
    })
    MantenimientoProducto toMantenimietoProducto(ProductMaintenace product);
}

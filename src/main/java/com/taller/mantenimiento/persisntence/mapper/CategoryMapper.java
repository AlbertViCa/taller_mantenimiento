package com.taller.mantenimiento.persisntence.mapper;


import com.taller.mantenimiento.business.domain.Category;
import com.taller.mantenimiento.persisntence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 *
 * Implementación del patrón Data Mapper.
 * Mappers que sirven para traducir nuestras clases dominio y entidades.
 *
 * */

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "description")
    })
    Category toCataegory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}

package com.taller.mantenimiento.persisntence.mapper;

import com.taller.mantenimiento.business.domain.Product;
import com.taller.mantenimiento.persisntence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "marca", target = "trademark"),
            @Mapping(source = "modelo", target = "model"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "categoria", target = "category")//Aquí hacemos uso del CategoryMapper, por eso indicamos en la notación @Mapper que haga uso de esa clase
    })
    Product toProducto(Producto producto);
    List<Product> toProducto(List<Producto> productos);

    @InheritInverseConfiguration
    Producto toProducto(Product product);
}

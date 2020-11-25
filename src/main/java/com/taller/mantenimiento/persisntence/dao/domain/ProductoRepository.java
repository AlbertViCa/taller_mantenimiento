package com.taller.mantenimiento.persisntence.dao.domain;

import com.taller.mantenimiento.business.domain.Product;
import com.taller.mantenimiento.business.domain.repository.ProductRepository;
import com.taller.mantenimiento.persisntence.crud.ProductoCrudRepository;
import com.taller.mantenimiento.persisntence.entity.Producto;
import com.taller.mantenimiento.persisntence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * Repositorio que se comunicará directamente con la Base de Datos.//
 *
 * */

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired //Inyección de dependencias
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByMarcaAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));//Ya que espera una lista de opcionales, se puede usar el métodp of, y ya que espera una lista de product, convertimos los productos.
    }

    @Override
    public Optional<Product> getProduct(int idProduct) {
        return productoCrudRepository.findById(idProduct).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}

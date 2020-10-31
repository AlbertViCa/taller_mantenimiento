package com.taller.mantenimiento.business.domain.repository;

import com.taller.mantenimiento.business.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 *
 * Esta interface sirve para indicarle a los repositorios como se deben comportar cuando quieran acceder a la Base de Datos,
 * esto sirve para no depender de una BD específica sino que siempre estemos hablano en términos del dominio, es decir, en términos del negocio.
 *
 * */

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<Product> getProduct(int idProduct);
    Product save(Product product);
    void delete(int productId);
}

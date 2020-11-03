package com.taller.mantenimiento.persisntence.crud;

import com.taller.mantenimiento.persisntence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
    Optional<List<Cliente>> findByClienteId(String clietneId);
}

package com.taller.mantenimiento.persisntence.crud;

import com.taller.mantenimiento.persisntence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
    Optional<List<Cliente>> findByClienteId(String clietneId);
}

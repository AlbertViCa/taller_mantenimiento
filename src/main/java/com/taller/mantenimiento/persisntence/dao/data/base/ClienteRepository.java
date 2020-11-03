package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.crud.ClienteCrudRepository;
import com.taller.mantenimiento.persisntence.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository {

    @Autowired
    ClienteCrudRepository clienteCrudRepository;

    public Optional<List<Cliente>> findById(String clienteId){
        return clienteCrudRepository.findByClienteId(clienteId);
    }

    public Cliente guardar(Cliente cliente){
        return cliente = clienteCrudRepository.save(cliente);
    }
}

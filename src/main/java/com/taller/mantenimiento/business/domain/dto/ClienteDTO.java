package com.taller.mantenimiento.business.domain.dto;

import com.taller.mantenimiento.persisntence.dao.data.base.ClienteRepository;
import com.taller.mantenimiento.persisntence.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDTO {

    ClienteRepository clienteRepository = new ClienteRepository();

    public void getClientData(String clave, String nombre, String apellidos, Long telefono, String correo){
        Cliente cliente = new Cliente(clave, nombre, apellidos, telefono, correo);
        clienteRepository.saveData(cliente);
    }
}

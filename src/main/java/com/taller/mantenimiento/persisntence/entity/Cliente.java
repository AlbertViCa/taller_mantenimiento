package com.taller.mantenimiento.persisntence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id")
    private String clienteId;

    private String nombre;

    private String apellidos;

    private Integer celular;

    @Column(name = "correo_electronico")
    private String correoElectronico;
}

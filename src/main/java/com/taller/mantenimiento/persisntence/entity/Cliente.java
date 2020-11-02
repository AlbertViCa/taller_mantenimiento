package com.taller.mantenimiento.persisntence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "id")
    private String clienteId;

    private String nombre;

    private String apellidos;

    private Long celular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Mantenimiento> mantenimientoList;

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }
}

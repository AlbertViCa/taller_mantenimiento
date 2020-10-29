package com.taller.mantenimiento.persisntence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idManenimiento;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    private boolean estado;

    public Integer getIdManenimiento() {
        return idManenimiento;
    }

    public void setIdManenimiento(Integer idManenimiento) {
        this.idManenimiento = idManenimiento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

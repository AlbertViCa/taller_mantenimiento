package com.taller.mantenimiento.persisntence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@SuppressWarnings("ALL")

@Embeddable
public class MantenimientoProductoPK implements Serializable {

    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;

    @Column(name = "id_producto")
    private  Integer idProducto;

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}

package com.taller.mantenimiento.persisntence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("ALL")

/*
* Cuando una clase contiene más de una llave primaria, es necesario crear una clase con la notación @Embeddable para establecer esas llaves
* */

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MantenimientoProductoPK)) return false;
        MantenimientoProductoPK that = (MantenimientoProductoPK) o;
        return Objects.equals(getIdMantenimiento(), that.getIdMantenimiento()) &&
                Objects.equals(getIdProducto(), that.getIdProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMantenimiento(), getIdProducto());
    }
}

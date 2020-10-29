package com.taller.mantenimiento.persisntence.entity;


import javax.persistence.*;

@Entity
@Table(name = "mantenimiento_productos")
public class MantenimientoProducto {

    @EmbeddedId
    private MantenimientoProductoPK id;

    private Integer total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_mantenimiento", insertable = false, updatable = false)
    private Mantenimiento mantenimiento;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public MantenimientoProductoPK getId() {
        return id;
    }

    public void setId(MantenimientoProductoPK id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}

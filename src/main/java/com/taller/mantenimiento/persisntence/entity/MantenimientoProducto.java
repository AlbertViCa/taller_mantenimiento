package com.taller.mantenimiento.persisntence.entity;


import javax.persistence.*;

@Entity
@Table(name = "mantenimiento_productos")
public class MantenimientoProducto {

    @EmbeddedId
    private MantenimientoProductoPK id;

    private double total;

    private Boolean estado;

    @ManyToOne
    @MapsId("idMantenimiento")//Cuando se haga la operación de cascada, cada producto sabrá a que clave primaria pertenece cada dentro de un mantenimiento.
    @JoinColumn(name = "id_mantenimiento", insertable = false, updatable = false)
    private Mantenimiento mantenimiento;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public MantenimientoProducto() {

    }

    public MantenimientoProducto(MantenimientoProductoPK id, double total, Boolean estado) {
        this.id = id;
        this.total = total;
        this.estado = estado;
    }

    public MantenimientoProductoPK getId() {
        return id;
    }

    public void setId(MantenimientoProductoPK id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}

package com.taller.mantenimiento.persisntence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Integer idMantenimiento;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "mantenimiento", cascade = {CascadeType.ALL}) //Cascade sirve para indicar que todos los proceso que se hagan el la BD de un mantenimiento van a incluir en cascada sus productos.
    private List<MantenimientoProducto> productos;

    public Mantenimiento() {
    }

    public Mantenimiento(Integer idMantenimiento, String idCliente, LocalDateTime fecha, boolean estado) {
        this.idMantenimiento = idMantenimiento;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(Integer idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<MantenimientoProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<MantenimientoProducto> productos) {
        this.productos = productos;
    }
}

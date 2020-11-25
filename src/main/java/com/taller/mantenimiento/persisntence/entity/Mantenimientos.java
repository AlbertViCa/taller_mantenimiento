package com.taller.mantenimiento.persisntence.entity;

import java.util.Date;

public class Mantenimientos {
    private int idMantenimiento;
    private String idCleinte;
    private int idProducto;
    private double total;
    private Date fecha;
    private boolean estado;

    public Mantenimientos(String idCleinte, int idProducto, double total, Date fecha, boolean estado) {
        this.idCleinte = idCleinte;
        this.idProducto = idProducto;
        this.total = total;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Mantenimientos(){

    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public String getIdCleinte() {
        return idCleinte;
    }

    public void setIdCleinte(String idCleinte) {
        this.idCleinte = idCleinte;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

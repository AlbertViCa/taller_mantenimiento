package com.taller.mantenimiento.persisntence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    @OneToMany(mappedBy = "categoria")//mappedBy es para respaldar la información que acabamos de crear o ¿qué atributo justifica que una categoria pertenece a muchos productos?
    private List<Producto> productos;

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

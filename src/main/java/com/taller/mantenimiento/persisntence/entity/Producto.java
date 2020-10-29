package com.taller.mantenimiento.persisntence.entity;


import javax.persistence.*;

@Entity//Esta notación le da entender a Java que esta clase se utlilizará para mapear una tabla de Base de Datos
@Table(name = "productos")
public class Producto {

    @Id//Al atributo que representa la clase primaria se le agrega esta etiqueta
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Se agrega esta notacion para agregar automaticamente un id al producto, se utiliza IDENTITY ya que es un valor de identificacion del priducto
    @Column(name = "id_producto")//Esta notación se utiliza siempre y cuando el nombre de la columna se adiferente al nombre del atributo
    private Integer idProducto;

    private String marca;//Si el nombre de la variable coincide con el de la columna, no es necesario agregar notación

    private String modelo;

    private String descripcion;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}

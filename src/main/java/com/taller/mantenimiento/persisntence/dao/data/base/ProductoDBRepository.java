package com.taller.mantenimiento.persisntence.dao.data.base;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

@Repository
public class ProductoDBRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into productos(marca, modelo, descripcion, id_categoria) values(?,?,?,?)");

            System.out.println("Dame la marca del producto");
            ps.setString(1, teclado.next());

            System.out.println("Dame el modelo del producto");
            ps.setString(2, teclado.next());

            System.out.println("Dame la descripción de la problemática");
            ps.setString(3, teclado.next());

            System.out.println("Categoría a la que pertenece este producto");
            ps.setInt(4, teclado.nextInt());

            int resultado = ps.executeUpdate();//Se ejecuta la inserción

            if(resultado>0){
                System.out.println("Producto registrado exitosamente");
            }else{
                System.out.println("Error en el registro");
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void getProduct(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from productos where id_producto=?");
            ps.setInt(1, teclado.nextInt());
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("marca"));
                System.out.println(rs.getString("modelo"));
                System.out.println(rs.getString("descripcion"));
                System.out.println(rs.getInt("id_categoria"));
            }
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void getData(){
        try{
            //Puede retornar listas de clientes, cambiar if a while cuando haya más datos
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from productos");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Marca: " + rs.getString("marca") + "\nModelo: " + rs.getString("modelo")+ "\nDescripcion: " + rs.getString("descripcion") + "\nCategoria: " + rs.getInt("id_categoria")+"\n");
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void update(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update productos set marca=?, modelo=?, descripcion=?, id_categoria=? where id_producto=?");

            System.out.println("Dame la marca del producto");
            ps.setString(1, teclado.next());

            System.out.println("Dame el modelo del producto");
            ps.setString(2, teclado.next());

            System.out.println("Dame la descripción de la problemática");
            ps.setString(3, teclado.next());

            System.out.println("Categoría a la que pertenece este producto");
            ps.setInt(4, teclado.nextInt());

            int resultado = ps.executeUpdate();//Se ejecuta la modificación

            if(resultado>0){
                System.out.println("Producto modificado exitosamente");
            }else{
                System.out.println("Error en la modificación");
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void delete(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("delete from productos where id_producto=?");

            System.out.println("Dame el id del producto a eliminar");
            ps.setInt(1, teclado.nextInt());

            int resultado = ps.executeUpdate();//Se ejecuta la eliminación

            if(resultado>0){
                System.out.println("Producto eliminado exitosamente");
            }else{
                System.out.println("Error en la eliminación");
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }
}

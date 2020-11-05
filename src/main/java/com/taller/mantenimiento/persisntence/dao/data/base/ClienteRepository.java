package com.taller.mantenimiento.persisntence.dao.data.base;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

@Repository
public class ClienteRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into clientes(id, nombre, apellidos, celular, correo_electronico=?) values(?,?,?,?,?)");

            System.out.println("Dame la id del cliente");
            ps.setString(1, teclado.next());

            System.out.println("Dame el nombre del cliente");
            ps.setString(2, teclado.next());

            System.out.println("Dame los apellidos del cliente");
            ps.setString(3, teclado.next());

            System.out.println("Dame el numero del cliente");
            ps.setLong(4, teclado.nextLong());

            System.out.println("Dame el correo elelctronico del cliente");
            ps.setString(5, teclado.next());

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

    public void getClient(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from clientes where id=?");
            System.out.println("Dame la id del cliente");
            ps.setString(1, teclado.next());
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("apellidos"));
                System.out.println(rs.getString("celular"));
                System.out.println(rs.getString("correo_electronico"));
            }
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void getData(){
        //Puede retornar listas de clientes, cambiar if a while cuando haya más datos
        Connection connection = dataBaseConnector.getConnection();
        try{
            ps = connection.prepareStatement("select * from clientes");
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Nombre: " + rs.getString("nombre") + "\nApellidos: " + rs.getString("apellidos")+ "\nCelular: " + String.valueOf(rs.getLong("celular")) + "\nE-Mail: " + rs.getString("correo_electronico"));
            }else{
                System.out.println("No existen datos");
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void update(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update clientes set id=?, nombre=?, apellidos=?, celular=?, correo_electronico=? where id=?");

            System.out.println("Dame el identificador del cliente");
            ps.setString(1, teclado.next());

            System.out.println("Dame el nombre del cliente");
            ps.setString(2, teclado.next());

            System.out.println("Dame los apellidos del cliente");
            ps.setString(3, teclado.next());

            System.out.println("Categoría el celular del cliente");
            ps.setLong(4, teclado.nextLong());

            System.out.println("Dame el correo electronico del cliente");
            ps.setString(5, teclado.next());

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
            ps = connection.prepareStatement("delete from clientes where id=?");

            System.out.println("Dame el cliente a leiminar");
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

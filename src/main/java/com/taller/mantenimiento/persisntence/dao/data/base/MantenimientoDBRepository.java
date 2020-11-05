package com.taller.mantenimiento.persisntence.dao.data.base;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

@Repository
public class MantenimientoDBRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into mantenimiento(id_cliente, fecha, estado) values(?,?,?)");

            System.out.println("Dame la id del cliente");
            ps.setString(1, teclado.next());

            System.out.println("dame la id del producto");
            ps.setDate(2, Date.valueOf(teclado.next()));

            System.out.println("Dame el costo total del mantenimiento ");
            ps.setBoolean(3, false);

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

    public void getMaintenance(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from mantenimiento where id_mantenimiento=?");
            System.out.println("Dame la id del mantenimiento");
            ps.setInt(1, teclado.nextInt());
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getString("id_cliente"));
                System.out.println(rs.getDate("fecha"));
                System.out.println(rs.getBoolean("estado"));
            }
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void getData(){
        try{
            //Puede retornar listas de clientes, cambiar if a while cuando haya más datos
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from mantenimiento");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("ID Cliente: " + rs.getString("id_cliente") + "\nEstado: " + rs.getDate("fecha") + rs.getDouble("estado"));
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void update(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update mantenimiento set id_cliente=?, fecha=?, estado=? where id_mantenimiento=?");

            System.out.println("Dame el id del cliente");
            ps.setString(1, teclado.next());

            System.out.println("Dame la fecha de entrega");
            ps.setDate(2, Date.valueOf(teclado.next()));

            System.out.println("Dame el estado del mantenimiento");
            ps.setBoolean(2, teclado.nextBoolean());

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
            ps = connection.prepareStatement("delete from mantenimiento where id_mantenimiento=?");

            System.out.println("Dame el id del producto para eliminar su mantenimiento");
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

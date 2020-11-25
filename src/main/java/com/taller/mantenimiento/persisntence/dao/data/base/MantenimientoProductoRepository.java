package com.taller.mantenimiento.persisntence.dao.data.base;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

@Repository
public class MantenimientoProductoRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(int idProducto, int idMantenimiento, double total){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into mantenimiento_prodcutos(id_mantenimiento, id_prodcuto, total, estado) values(?,?,?,?)");

            ps.setInt(1, idMantenimiento);

            ps.setInt(2, idProducto);

            ps.setDouble(3, total);

            ps.setBoolean(4, false);

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

    public void getMaintenanceProduct(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from mantenimiento_productos where id_producto=?");
            System.out.println("Dame la id de producto");
            ps.setInt(1, teclado.nextInt());
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getDouble("total"));
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
            ps = connection.prepareStatement("select * from mantenimiento_productos");
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Total: " + rs.getString("total") + "\nEstado: " + rs.getString("estado"));
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void update(){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update mantenimiento_productos set total=?, estado=? where id_producto=?");

            System.out.println("Dame la marca del producto");
            ps.setDouble(1, teclado.nextDouble());

            System.out.println("Dame el modelo del producto");
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
            ps = connection.prepareStatement("delete from mantenimiento_prodcutos where id_producto=?");

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

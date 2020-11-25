package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.entity.Cliente;
import com.taller.mantenimiento.persisntence.entity.Mantenimientos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class MantenimientosDBRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(String idCliente, int idProducto, double total, String fecha){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into mantenimientos(id_cliente, id_producto, total, fecha_entrega, estado) values(?,?,?,?,?)");

            ps.setString(1, idCliente);
            ps.setInt(2, idProducto);
            ps.setDouble(3, total);
            ps.setDate(4, Date.valueOf(fecha));
            ps.setBoolean(5,false);

            int resultado = ps.executeUpdate();//Se ejecuta la inserción
            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Mantenimiento registrado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en el registro", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public Mantenimientos getMantenimiento(int id){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from mantenimientos where id_mantenimiento=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while(rs.next()){
                return new Mantenimientos(rs.getString("id_cliente"), rs.getInt("id_producto"), rs.getDouble("total"), rs.getDate("fecha_entrega"), rs.getBoolean("estado"));
            }
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
        return null;
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

    public void update(int id, Mantenimientos mantenimiento){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update mantenimientos set id_cliente=?, id_producto=?, total=?, fecha_entrega=?, estado=? where id_mantenimiento=?");
            ps.setString(1, mantenimiento.getIdCleinte());
            ps.setInt(2, mantenimiento.getIdProducto());
            ps.setDouble(3, mantenimiento.getTotal());
            ps.setDate(4, (Date) mantenimiento.getFecha());
            ps.setBoolean(5, mantenimiento.isEstado());
            
            ps.setInt(6, id);

            int resultado = ps.executeUpdate();//Se ejecuta la modificación

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Mantenimiento modificado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en la actualización", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void delete(int id){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("delete from mantenimientos where id=?");

            ps.setInt(1, teclado.nextInt());

            int resultado = ps.executeUpdate();//Se ejecuta la eliminación

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Mantenimiento eliminado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en la eliminación", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }
}

package com.taller.mantenimiento.persisntence.dao.data.base;

import com.taller.mantenimiento.persisntence.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

@Repository
public class ClienteRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(Cliente cliente){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into clientes(id, nombre, apellidos, celular, correo_electronico) values(?,?,?,?,?)");

            ps.setString(1, cliente.getClienteId());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellidos());
            ps.setLong(4, cliente.getCelular());
            ps.setString(5, cliente.getCorreoElectronico());

            int resultado = ps.executeUpdate();//Se ejecuta la inserción
            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en el registro", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public Cliente getClient(String id){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("select * from clientes where id=?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            while(rs.next()){
                return new Cliente(rs.getString("id"),rs.getString("nombre"),rs.getString("apellidos"),rs.getLong("celular"),rs.getString("correo_electronico"));
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

    public void update(String id, Cliente cliente){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update clientes set id=?, nombre=?, apellidos=?, celular=?, correo_electronico=? where id=?");

            ps.setString(1, cliente.getClienteId());

            ps.setString(2, cliente.getNombre());

            ps.setString(3, cliente.getApellidos());

            ps.setLong(4, cliente.getCelular());

            ps.setString(5, cliente.getCorreoElectronico());
            
            ps.setString(6, id);

            int resultado = ps.executeUpdate();//Se ejecuta la modificación

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Cliente modificado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en la modificación", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void delete(String id){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("delete from clientes where id=?");

            System.out.println("Dame el cliente a leiminar");
            ps.setString(1, id);

            int resultado = ps.executeUpdate();//Se ejecuta la eliminación

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en la eliminación", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }
}

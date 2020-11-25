package com.taller.mantenimiento.persisntence.dao.data.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.taller.mantenimiento.persisntence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

@Repository
public class ProductoDBRepository {
    private PreparedStatement ps;
    private ResultSet rs;
    private final DataBaseConnector dataBaseConnector = new DataBaseConnector();
    private final Scanner teclado = new Scanner(System.in);

    public void saveData(Producto producto){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("insert into productos(marca, modelo, descripcion, id_categoria) values(?,?,?,?)");

            ps.setString(1, producto.getMarca());
            ps.setString(2, producto.getModelo());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getIdCategoria());

            int resultado = ps.executeUpdate();//Se ejecuta la inserción

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Producto registrado exitosamente");
            }else{
                System.out.println("Error en la modificación");
                JOptionPane.showMessageDialog(null, "Error en el registro", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public Producto getProduct(int id){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("SELECT * FROM productos WHERE id_producto=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while(rs.next()){
                return new Producto(rs.getString("marca"),rs.getString("modelo"),rs.getString("descripcion"),rs.getInt("id_categoria"));
            }
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
        return null;
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

    public void update(int id, Producto producto){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("update productos set marca=?, modelo=?, descripcion=?, id_categoria=? where id_producto=?");

            ps.setString(1, producto.getMarca());

            ps.setString(2, producto.getModelo());

            ps.setString(3, producto.getDescripcion());

            ps.setInt(4, producto.getIdCategoria());
            
            ps.setInt(5, id);

            int resultado = ps.executeUpdate();//Se ejecuta la modificación

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Producto modificado exitosamente");
            }else{
                System.out.println("Error en la modificación");
                JOptionPane.showMessageDialog(null, "Error en la modificación", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }

    public void delete(int id){
        try{
            Connection connection = dataBaseConnector.getConnection();
            ps = connection.prepareStatement("delete from productos where id_producto=?");

            ps.setInt(1, id);

            int resultado = ps.executeUpdate();//Se ejecuta la eliminación

            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error en la eliminación", "Error", ERROR_MESSAGE);
            }
            connection.close();
        }catch (Exception ex){
            System.out.println("ERROR: "+ex);
        }
    }
}

package com.taller.mantenimiento;

import com.taller.mantenimiento.persisntence.dao.data.base.DataBaseConnector;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

@SpringBootTest
class TallerMantenimientoApplicationTests {

	private PreparedStatement ps;
	private ResultSet rs;
	private final DataBaseConnector dataBaseConnector = new DataBaseConnector();
	private final Scanner teclado = new Scanner(System.in);

	@Test
	void contextLoads() {
	}

	@Test
	public void saveProductoDataTest(){
		try{
			Connection connection = dataBaseConnector.getConnection();
			ps = connection.prepareStatement("insert into productos(marca, modelo, descripcion, id_categoria) values(?,?,?,?)");

			ps.setString(1, "Samnsung");

			ps.setString(2, "Galaxy S6 Edge");

			ps.setString(3, "Cambio de pantalla rota");

			ps.setInt(4, 8);

			int resultado = ps.executeUpdate();

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

	@Test
	public void getProducDatatTest(){
		try{
			Connection connection = dataBaseConnector.getConnection();
			ps = connection.prepareStatement("select * from productos where id_producto=?");
			ps.setInt(1, 4);
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

	@Test
	public void getProducstDataTest(){
		try{
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

	@Test
	public void updateProductTest(){
		try{
			Connection connection = dataBaseConnector.getConnection();
			ps = connection.prepareStatement("update productos set marca=?, modelo=?, descripcion=?, id_categoria=? where id_producto=?");

			ps.setString(1, "IPhone");

			ps.setString(2, "4S");

			ps.setString(3, "Desbloqueo");

			ps.setInt(4, 8);

			ps.setInt(5, 4);

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

	@Test
	public void deleteProductTest(){
		try{
			Connection connection = dataBaseConnector.getConnection();
			ps = connection.prepareStatement("delete from productos where id_producto=?");

			ps.setInt(1, 4);

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

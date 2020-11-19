package com.taller.mantenimiento;

import com.taller.mantenimiento.persisntence.dao.data.base.ClienteRepository;
import com.taller.mantenimiento.persisntence.dao.data.base.DataBaseConnector;
import com.taller.mantenimiento.persisntence.dao.data.base.ProductoDBRepository;
import com.taller.mantenimiento.persisntence.entity.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TallerMantenimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerMantenimientoApplication.class, args);
		Cliente cliente = new Cliente();

		ProductoDBRepository connector = new ProductoDBRepository();

		connector.getData();
	}
}

package com.taller.mantenimiento;

import com.taller.mantenimiento.persisntence.dao.data.base.ClienteRepository;
import com.taller.mantenimiento.persisntence.dao.data.base.DataBaseConnector;
import com.taller.mantenimiento.persisntence.dao.data.base.ProductoDBRepository;
import com.taller.mantenimiento.persisntence.entity.Cliente;
import com.taller.mantenimiento.view.Registro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TallerMantenimientoApplication {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(TallerMantenimientoApplication.class, args);
		new Registro().setVisible(true);
	}
}

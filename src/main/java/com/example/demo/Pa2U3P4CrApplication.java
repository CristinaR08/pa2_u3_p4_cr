package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;


@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner {
	
	@Autowired
	private IPropietarioService propietarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("main: "+TransactionSynchronizationManager.isActualTransactionActive());
		Propietario prop = new Propietario();
		prop.setNombre("C");
		prop.setApellido("R");
		prop.setCedula("17");
		this.propietarioService.agregar(prop);
	}
}
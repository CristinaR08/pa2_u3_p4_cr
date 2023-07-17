package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITranferenciaService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner{
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private ITranferenciaService tranferenciaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	//1)Guardar cta bancaria1	
	Propietario p1 = new Propietario();
	p1.setNombre("Sara");
	p1.setApellido("Altamirano");
	p1.setCedula("1896532001");
	this.propietarioService.agregar(p1);
	
	CuentaBancaria cb1 = new CuentaBancaria();
	cb1.setNumero("0027896532");
	cb1.setSaldo(new BigDecimal(130.75));
	cb1.setTipo("Ahorros");
	cb1.setPropietario(p1);
	this.bancariaService.agregar(cb1);
	
	//segunda cuenta
	Propietario p2 = new Propietario();
	p2.setNombre("Antonio");
	p2.setApellido("Vivas");
	p2.setCedula("1724698530");
	this.propietarioService.agregar(p2);
	
	CuentaBancaria cb2 = new CuentaBancaria();
	cb2.setNumero("0239765894");
	cb2.setSaldo(new BigDecimal(15.50));
	cb2.setTipo("Corriente");
	cb2.setPropietario(p2);
	this.bancariaService.agregar(cb2);	
	
	
	//2)Realizar transferencia (String ctaOrigen, String ctaDestino, BigDecimal Monto)
	
	this.tranferenciaService.realizar("0027896532", "0239765894", new BigDecimal(45.50));

	//Reporte Todas las transferencias
	
	System.out.println(this.tranferenciaService.reporteTransferencias());
	
	}
}

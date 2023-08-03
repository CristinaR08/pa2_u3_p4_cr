package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITranferenciaService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner {

	@Autowired
	private ITranferenciaService tranferenciaService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	Transferencia transfer = new Transferencia();

	@Override
	public void run(String... args) throws Exception {

		System.out.println("main: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.tranferenciaService.realizar("0027896532", "0239765894", new BigDecimal(95.00));
	}
}

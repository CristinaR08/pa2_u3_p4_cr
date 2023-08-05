package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4CrApplication.class);

	
	@Autowired
	private ICuentaBancariaService bancariaService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	Transferencia transfer = new Transferencia();

	@Override
	public void run(String... args) throws Exception {

		LOG.info("Hilo: "+ Thread.currentThread().getName());
/*
		//inicio
		long tiempoInicial = System.currentTimeMillis();
		for(int i=1; i<=30;i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			this.bancariaService.agregar(ctaOrigen);
		}
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
*/
		
		/*
		 //inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for(int i=1; i<=100;i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			lista.add(ctaOrigen);
		}
		
		//lista.stream().forEach(cta ->this.bancariaService.agregar(cta));
		lista.parallelStream().forEach(cta ->this.bancariaService.agregar(cta));	
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);

		 */
		
		//inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for(int i=1; i<=100;i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			lista.add(ctaOrigen);
		}
		
		//lista.stream().forEach(cta ->this.bancariaService.agregar(cta));
		//lista.parallelStream().forEach(cta ->this.bancariaService.agregar2(cta));	
		
		Stream<String> listaFinal = lista.parallelStream().map(cta ->this.bancariaService.agregar2(cta));	
		LOG.info("Se guaradaron las siguientes cuentas:");
		listaFinal.forEach(cadena->LOG.info(cadena));
		
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		
	}
}


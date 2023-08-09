package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;

@SpringBootApplication
@EnableAsync
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
//Asincrono sin respuesta
		/*LOG.info("Hilo: "+ Thread.currentThread().getName());

		long tiempoInicial = System.currentTimeMillis();
		List<CuentaBancaria> lista = new ArrayList<>();
		for(int i=1; i<=10;i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			lista.add(ctaOrigen);
			this.bancariaService.agregarAsincrono(ctaOrigen); //no espera al retorno
		}	
		
		//fin
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: "+tiempoTranscurrido);
		LOG.info("Se terminó de procesar todo C:");
*/
	//Asincrono con respuesta futura
	LOG.info("Hilo: "+ Thread.currentThread().getName());

	long tiempoInicial = System.currentTimeMillis();
	List<CompletableFuture<String>> listaRespuestas = new ArrayList<>();
	List<CuentaBancaria> lista = new ArrayList<>();
	for(int i=1; i<=10;i++) {
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setNumero(String.valueOf(i));
		ctaOrigen.setSaldo(new BigDecimal(100));
		ctaOrigen.setTipo("A");
		lista.add(ctaOrigen);
		CompletableFuture<String> respuesta =this.bancariaService.agregarAsincrono2(ctaOrigen); 
	//capturo la respuesta en un objeto de tipo CompletableFuture
		listaRespuestas.add(respuesta);
	}	
	//sentencia que espera qu eterminen de procesarse todos los hilos para
	//obtener la respuesta
	CompletableFuture.allOf(listaRespuestas.get(0), listaRespuestas.get(1), listaRespuestas.get(2),
			listaRespuestas.get(3),listaRespuestas.get(4), listaRespuestas.get(5), listaRespuestas.get(6),
			listaRespuestas.get(7),listaRespuestas.get(8), listaRespuestas.get(9));
	
	LOG.info("Respuesta 0: " + listaRespuestas.get(0).get());
	
	
	long tiempoFinal = System.currentTimeMillis();
	long tiempoTranscurrido = (tiempoFinal-tiempoInicial)/1000;
	LOG.info("Tiempo transcurrido: "+(tiempoFinal-tiempoInicial)+" milisegundos");
	LOG.info("Tiempo transcurrido: "+tiempoTranscurrido+" segundos");
	LOG.info("Se terminó de procesar todo C:");

	}
}


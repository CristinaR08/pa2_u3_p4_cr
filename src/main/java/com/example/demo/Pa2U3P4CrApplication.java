package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Pedidos;
import com.example.demo.service.IClienteService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner{
	
	@Autowired
	private IClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("InnerJOIN_1");
		System.out.println("Resultado: "+this.clienteService.encontrarInnerJoin()); 
		
		System.out.println("InnerJOIN_2");
		System.out.println("Resultado: "+this.clienteService.encontrarInnerJoin_2()); 
		 
		System.out.println("OuterLeftJOIN_1");
		System.out.println("Resultado: "+this.clienteService.encontrarOuterLefttJoin()); 
  
		System.out.println("OuterLeftJOIN_2");
		System.out.println("Resultado: "+this.clienteService.encontrarOuterLefttJoin_2()); 
  
		System.out.println("OuterRightJOIN_1");
		System.out.println("Resultado: "+this.clienteService.encontrarOuterRightJoin()); 
  
		System.out.println("OuterRightJOIN_2");
		System.out.println("Resultado: "+this.clienteService.encontrarOuterRightJoin_2()); 
  
		System.out.println("OuterFullJOIN_2");
		System.out.println("Resultado: "+this.clienteService.encontrarOuterFullJoin());
		
		System.out.println("OuterFullJOIN_2");
		System.out.println("Resultado: "+this.clienteService.encontrarOuterFullJoin_2());
		
		System.out.println("WhereJOIN");
		System.out.println("Resultado: "+this.clienteService.encontrarWhereJoin());
		
		System.out.println("WhereJOIN_2");
		System.out.println("Resultado: "+this.clienteService.encontrarWhereJoin_2());
		
		System.out.println("JOINFetch");
		System.out.println("Resultado: "+this.clienteService.encontrarFetchJoin());
		
		 System.out.println("SQL Join Fetch_2");
		 List<Cliente> listaCliente = this.clienteService.encontrarFetchJoin(); 
		 for(Cliente c:listaCliente) { 
			 System.out.println(c.getNombre());
			 System.out.println("FETCH tiene los siguientes clientes");
			 for(Pedidos p:c.getPedidos()) {
				 System.out.println(p.getProducto());
			 }
		 }		
	}
}

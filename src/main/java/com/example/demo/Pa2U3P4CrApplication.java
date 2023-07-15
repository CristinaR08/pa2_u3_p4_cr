package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Inner"); //mas usado
		List<Hotel> listaHotel = this.hotelService.encontrarInnerJoin(); 
		 for(Hotel h:listaHotel) { 
			 System.out.println(h.getNombre());
			 System.out.println("tiene las siguientes habitaciones");
			 for(Habitacion ha:h.getHabitaciones()) {
				 System.out.println(ha.getNumero());
			 }
			 //Me da un error porque tengo el LAZY, estoy accediendo a un dato que tiene lazy 
			 }
		 System.out.println("SQL Join Fetch");
		 List<Hotel> listaHotelF = this.hotelService.buscarJoinFetch(); 
		 for(Hotel h:listaHotelF) { 
			 System.out.println(h.getNombre());
			 System.out.println("FETCH tiene las siguientes habitaciones");
			 for(Habitacion ha:h.getHabitaciones()) {
				 System.out.println(ha.getNumero());
			 }
			 //mas eficiente si es bajo demanda
			 Hotel hotel1 = new Hotel();
			 hotel1.setId(7);
			 hotel1.setDireccion("Av. 6 de Diciembre");
			 hotel1.setNombre("Hotel Marriot");
			 //this.hotelService.agregar(hotel1);
			 
			 Habitacion habi1 = new Habitacion();
			 habi1.setNumero("A32");
			 habi1.setValor(new BigDecimal(15.00));
			 habi1.setValorIncluidoIVA(new BigDecimal(17.50));
			 List<Habitacion> habitacion = new ArrayList<>();
			 habitacion.add(habi1);
			 hotel1.setHabitaciones(habitacion);
			 habi1.setHotel(hotel1);
			 //this.hotelService.agregar(hotel1);
			 
			 
			 
	}
	}
}

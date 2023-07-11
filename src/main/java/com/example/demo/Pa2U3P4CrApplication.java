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
import com.example.demo.service.HabitacionService;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U3P4CrApplication implements CommandLineRunner {

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4CrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel hotel = new Hotel();

		hotel.setDireccion("Av. Naciones Unidas");

		hotel.setNombre("Hotel Plaza 1");

		Habitacion habitacion = new Habitacion();

		habitacion.setHotel(hotel);

		habitacion.setNumero("34");

		habitacion.setValor(new BigDecimal(45));

		Habitacion habitacion1 = new Habitacion();

		habitacion1.setHotel(hotel);

		habitacion1.setNumero("37");

		habitacion1.setValor(new BigDecimal(48));

		Habitacion habitacion2 = new Habitacion();

		habitacion2.setHotel(hotel);

		habitacion2.setNumero("54");

		habitacion2.setValor(new BigDecimal(59));

		List<Habitacion> habitaciones = new ArrayList<>();

		habitaciones.add(habitacion);

		habitaciones.add(habitacion1);

		habitaciones.add(habitacion2);

		hotel.setHabitaciones(habitaciones);

		this.hotelService.agregar(hotel);

		
		 List<Hotel> listaHotel = this.hotelService.buscarInnerJoin(); 
		 for(Hotel hotel1:listaHotel) { 
			 System.out.println(hotel1); 
			 }
		
	}

}

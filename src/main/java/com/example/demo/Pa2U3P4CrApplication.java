package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
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
		
		System.out.println("Inner");
		List<Hotel> listaHotel = this.hotelService.encontrarInnerJoin(); 
		 for(Hotel hotel1:listaHotel) { 
			 System.out.println(hotel1); 
			 }
		 
		 System.out.println("OuterRight");
			List<Hotel> listaHotelRight = this.hotelService.encontrarOuterRightJoin(); 
			 for(Hotel hotel1:listaHotelRight) { 
				 System.out.println(hotel1); 
				 }
		 
		 System.out.println("OuterLeft");
		 List<Hotel> listaOuterLeft = this.hotelService.encontrarOuterLeftJoin();
		 for(Hotel h:listaOuterLeft) {
			 System.out.println(h);
		 }
		
		 List<Habitacion> habitacion = this.hotelService.encontrarHabitacionOuterLefttJoin();
		 for(Habitacion h:habitacion) {
			 System.out.println(h);
		 }
		 System.out.println("OuterFull");
		 List<Hotel> habitacionFull = this.hotelService.buscarOuterFullJoin();
		 for(Hotel h:habitacionFull) {
			 if(h==null) {
				 System.out.println("No existe");
			 }else {
			 System.out.println(h.getNombre());
		 }
		 
			 
		}
		 
		 System.out.println("JoinWhere");
		 List<Hotel> listaWhere = this.hotelService.buscarWhereJoin();
		 for(Hotel h:listaWhere) {
			 if(h==null) {
				 System.out.println("No existe");
			 }else {
			 System.out.println(h.getNombre());
		 }
		 
	}
	}
}

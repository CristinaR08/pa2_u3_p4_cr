package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public List<Hotel> seleccionarInnerJoin(); //ojo, en el examen no pide como "innerjoin"
	public void agregar(Hotel hotel);
	
}

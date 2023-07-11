package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelService implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public List<Hotel> buscarInnerJoin() {
		return this.hotelRepository.seleccionarInnerJoin();
	}

	@Override
	public void agregar(Hotel hotel) {
		this.hotelRepository.agregar(hotel);
		
	}


	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository ;
	
	@Override
	public void agregar(Hotel hotel) {
		this.hotelRepository.insertar(hotel);
		
	}

	@Override
	public void modificar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);
		
	}

	@Override
	public Hotel encontrar(Integer id) {
		return this.hotelRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.hotelRepository.eliminar(id);
		
	}

	@Override
	public List<Hotel> encontrarInnerJoin() {
		return this.hotelRepository.seleccionarInnerJoin();
	}

}

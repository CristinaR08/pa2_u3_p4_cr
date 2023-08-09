package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHotelRepository;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository ;
	
	@Override
	public void agregar(Hotel hotel) {
		for(Habitacion ha: hotel.getHabitaciones()) {
			ha.setValorIncluidoIVA(ha.getValor().multiply(new BigDecimal(1.12)));
		}
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

	@Override
	public List<Hotel> encontrarOuterRightJoin() {
		return this.hotelRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Hotel> encontrarOuterLeftJoin() {
		return this.hotelRepository.seleccionarOuterLefttJoin();
	}

	@Override
	public List<Habitacion> encontrarHabitacionOuterLefttJoin() {
		return this.hotelRepository.seleccionarHabitacionOuterLefttJoin();
	}

	@Override
	public List<Hotel> buscarOuterFullJoin() {
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Hotel> buscarWhereJoin() {
		return this.hotelRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Hotel> buscarJoinFetch() {
		return this.hotelRepository.seleccionarFetchJoin();
	}
	
}

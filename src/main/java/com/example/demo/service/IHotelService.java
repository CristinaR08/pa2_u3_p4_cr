package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface IHotelService {
	
	public void agregar(Hotel hotel);
	public void modificar(Hotel hotel);
	public Hotel encontrar(Integer id);
	public void borrar(Integer id);
	public List<Hotel> encontrarInnerJoin();
	public List<Hotel> encontrarOuterRightJoin();
	public List<Hotel> encontrarOuterLeftJoin();
	public List<Habitacion> encontrarHabitacionOuterLefttJoin();
	public List<Hotel> buscarOuterFullJoin();
	//where
	public List<Hotel> buscarWhereJoin();


}

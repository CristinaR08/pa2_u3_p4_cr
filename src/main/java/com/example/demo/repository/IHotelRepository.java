package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

public interface IHotelRepository {

	public void insertar(Hotel hotel);
	public void actualizar(Hotel hotel);
	public Hotel buscar(Integer id);
	public void eliminar(Integer id);
	public List<Hotel> seleccionarInnerJoin(); //ojo, en el examen no pide como "innerjoin"
	public List<Hotel> seleccionarOuterRightJoin();
	public List<Hotel> seleccionarOuterLefttJoin();
	public List<Habitacion> seleccionarHabitacionOuterLefttJoin();
	public List<Hotel> seleccionarOuterFullJoin();
	//where
	public List<Hotel> seleccionarWhereJoin();

}

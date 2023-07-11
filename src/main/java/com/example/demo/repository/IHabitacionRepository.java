package com.example.demo.repository;

import com.example.demo.repository.modelo.Habitacion;

public interface IHabitacionRepository {
	
	public void insertar(Habitacion hotel);
	public void actualizar(Habitacion hotel);
	public Habitacion buscar(Integer id);
	public void eliminar(Integer id);

}

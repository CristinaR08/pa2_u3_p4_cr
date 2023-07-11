package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IHabitacionRepository;
import com.example.demo.repository.modelo.Habitacion;

@Service
public class HabitacionService implements IHabitacionService{

	@Autowired
	private IHabitacionRepository habitacionRepo;

	@Override
	public void agregar(Habitacion habitacion) {
		this.habitacionRepo.insertar(habitacion);
	}

	@Override
	public void modificar(Habitacion habitacion) {
		this.habitacionRepo.actualizar(habitacion);
	}

	@Override
	public Habitacion encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.habitacionRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.habitacionRepo.eliminar(id);
		
	}
}

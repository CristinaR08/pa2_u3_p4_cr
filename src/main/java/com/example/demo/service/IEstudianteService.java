package com.example.demo.service;

import com.example.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public void agregar(Estudiante estudiante);
	public Estudiante encontrar(String cedula);
	
	
}

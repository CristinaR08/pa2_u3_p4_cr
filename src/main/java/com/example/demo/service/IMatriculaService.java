package com.example.demo.service;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {

	public void guardar(Matricula matricula);
	public Matricula encontrarCedula(String cedula);
	public void matricularPorCedula(String cedula);
	public void ingresarMatricula(String cedula);
}

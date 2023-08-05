package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Matricula;

public interface IMatriculaService {

	public void guardar(Matricula matricula);
	public Matricula encontrarCedula(String cedula);
	public void matricularPorCedula(String cedula, List<String> codigosMateria);
	public void ingresarMatricula(String cedula);
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepositoryImpl;
import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	
	@Override
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public Matricula encontrarCedula(String cedula) {
		return this.matriculaRepository.buscarCedula(cedula);
	}

	@Override
	public void matricularPorCedula(String cedula) {
		Estudiante e = this.estudianteRepository.buscar(cedula);
	}

}

package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepositoryImpl;
import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;

@Service
public class MatriculaServiceImpl implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMateriaRepository materiaRepository;

	
	@Override
	public void guardar(Matricula matricula) {
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public Matricula encontrarCedula(String cedula) {
		return this.matriculaRepository.buscarCedula(cedula);
	}

	@Override
	public void matricularPorCedula(String cedula, List<String> codigosMateria) {
		Estudiante estudianteBd = this.estudianteRepository.buscarCedula(cedula);

		for (String codigoLista : codigosMateria) {
			List<Materia> materiaBd = this.materiaRepository.listaMaterias(codigoLista);
			for (Materia materiaLista : materiaBd) {
				Matricula matricula = new Matricula();
				matricula.setEstudiante(estudianteBd);
				matricula.setFecha(LocalDateTime.now());
				matricula.setMateria(materiaLista);
				matricula.setEstado("Primera");
				matricula.setFecha(LocalDateTime.now());
				matricula.setMonto(new BigDecimal(0.0));
				this.matriculaRepository.insertar(matricula);
			}
	}
	
	}

	@Override
	public void ingresarMatricula(String cedula) {
		// TODO Auto-generated method stub
		
	}	

}

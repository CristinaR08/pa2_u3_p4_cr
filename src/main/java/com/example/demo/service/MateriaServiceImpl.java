package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public void agregar(Materia materia) {
		this.materiaRepository.insertar(materia);
	}

	@Override
	public Materia encontrarCodigo(String codigo) {
		return this.materiaRepository.buscarCodigo(codigo);
	}

}

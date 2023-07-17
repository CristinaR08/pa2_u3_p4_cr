package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
	
	@Autowired
	private IPropietarioRepository propietarioRepository;

	@Override
	public void agregar(Propietario propietario) {
		this.propietarioRepository.insertar(propietario);
	}

	@Override
	public void modificar(Propietario propietario) {
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	public Propietario encontrar(Integer id) {
		return this.propietarioRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.propietarioRepository.eliminar(id);
	}

}

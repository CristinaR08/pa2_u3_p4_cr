package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	public void modificar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria encontrarPorCuenta(String cuenta) {
		return this.bancariaRepository.buscarPorCuenta(cuenta);
	}

	@Override
	public void borrar(Integer id) {
		this.bancariaRepository.eliminar(id);
	}

}

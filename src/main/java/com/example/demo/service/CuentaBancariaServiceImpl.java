package com.example.demo.service;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaBancariaRepositoryImpl;
import com.example.demo.repository.ICuentaBancariaRepository;
import com.example.demo.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{
	
	private static final Logger LOG = LoggerFactory.getLogger(CuentaBancariaServiceImpl.class);

	
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public void agregar(CuentaBancaria cuentaBancaria) {
		LOG.info("HiloService: "+ Thread.currentThread().getName());
//sumar restar multiplicar: logica que demora 1 segundo
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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

	@Override
	public String agregar2(CuentaBancaria cuentaBancaria) {
		LOG.info("Hilo Servcice: " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.bancariaRepository.insertar(cuentaBancaria);
		return cuentaBancaria.getNumero();
	}

}

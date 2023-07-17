package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Transferencia;
import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	public void insertar(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria buscarPorCuenta(String cuenta);
	public void eliminar(Integer id);
	public List<Transferencia> seleccionarListaTransferencia();
	
}

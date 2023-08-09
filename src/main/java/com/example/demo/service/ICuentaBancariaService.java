package com.example.demo.service;

import java.util.concurrent.CompletableFuture;

import com.example.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	
	public void agregar(CuentaBancaria cuentaBancaria);
	public String agregar2(CuentaBancaria cuentaBancaria);
	public void modificar(CuentaBancaria cuentaBancaria);
	public CuentaBancaria encontrarPorCuenta(String cuenta);
	public void borrar(Integer id);
	public void agregarAsincrono(CuentaBancaria cuenta);
	public CompletableFuture<String> agregarAsincrono2(CuentaBancaria cuenta);
}

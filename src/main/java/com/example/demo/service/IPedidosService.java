package com.example.demo.service;

import com.example.demo.repository.modelo.Pedidos;

public interface IPedidosService {

	public void agregar(Pedidos pedidos);
	public void modificar(Pedidos pedidos);
	public Pedidos encontrar(Integer id);
	public void borrar(Integer id);
	
}

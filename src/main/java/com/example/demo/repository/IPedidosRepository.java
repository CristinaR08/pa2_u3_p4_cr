package com.example.demo.repository;

import com.example.demo.repository.modelo.Pedidos;

public interface IPedidosRepository {
	
	public void insertar(Pedidos pedidos);
	public void actualizar(Pedidos pedidos);
	public Pedidos buscarId(Integer id);
	public void eliminarId(Integer id);
	//joins

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPedidosRepository;
import com.example.demo.repository.modelo.Pedidos;

@Service
public class PedidosServiceImpl implements IPedidosService{

	@Autowired
	private IPedidosRepository pedidosRepository;
	
	@Override
	public void agregar(Pedidos pedidos) {
		this.pedidosRepository.insertar(pedidos);
		
	}

	@Override
	public void modificar(Pedidos pedidos) {
		this.pedidosRepository.actualizar(pedidos);
		
	}

	@Override
	public Pedidos encontrar(Integer id) {
		return this.pedidosRepository.buscarId(id);
	}

	@Override
	public void borrar(Integer id) {
		this.pedidosRepository.eliminarId(id);
		
	}

}

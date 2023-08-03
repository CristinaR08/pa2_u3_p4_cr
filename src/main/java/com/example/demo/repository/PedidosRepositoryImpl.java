package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Pedidos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PedidosRepositoryImpl implements IPedidosRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Pedidos pedidos) {
		this.entityManager.persist(pedidos);
		
	}

	@Override
	public void actualizar(Pedidos pedidos) {
		this.entityManager.merge(pedidos);
		
	}

	@Override
	public Pedidos buscarId(Integer id) {
		return this.entityManager.find(Pedidos.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.entityManager.remove(id);
		
	}

}

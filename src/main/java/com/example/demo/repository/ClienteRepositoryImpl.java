package com.example.demo.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Cliente;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Cliente cliente) {
		this.entityManager.persist(cliente);
		
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.entityManager.merge(cliente);
		
	}

	@Override
	public Cliente buscarId(Integer id) {
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void eliminarId(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	public List<Cliente> seleccionarInnerJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.apellido FROM Cliente c INNER JOIN c.pedidos p ON p.estado = 'Completado'",Cliente.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Cliente> seleccionarInnerJoin_2() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.id FROM Cliente c INNER JOIN c.pedidos p ON p.precio>=25.00",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarOuterLefttJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.direccion FROM Cliente c LEFT JOIN c.pedidos p ON p.cantidad=1",Cliente.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Cliente> seleccionarOuterLefttJoin_2() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.correo FROM Cliente c LEFT JOIN c.pedidos p ON p.fecha = :fechaPedido",Cliente.class);
		myQuery.setParameter("fechaPedido", LocalDateTime.of(2023, 07, 10, 0, 0));
		return myQuery.getResultList();
	}


	@Override
	public List<Cliente> seleccionarOuterRightJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.telefono FROM Cliente c RIGHT JOIN c.pedidos p ON p.cliente.id = 1",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarOuterRightJoin_2() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.id FROM Cliente c RIGHT JOIN c.pedidos p ON p.estado='En proceso'",Cliente.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Cliente> seleccionarOuterFullJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c FULL JOIN c.pedidos p ON p.estado='Completado'",Cliente.class);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Cliente> seleccionarOuterFullJoin_2() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.fechaRegistro FROM Cliente c FULL JOIN c.pedidos p ON p.precio>=20.00",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarWhereJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c, Pedidos p WHERE c.id= p.cliente.id AND p.precio>=20.00",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarWhereJoin_2() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c.nombre FROM Cliente c, Pedidos p WHERE c.id= p.cliente.id AND p.producto = 'Zapatos'",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Cliente> seleccionarFetchJoin() {
		TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c JOIN FETCH c.pedidos p",Cliente.class); //JOIN e INNER JOIN son lo mismo, solo es abreviacion
		return myQuery.getResultList();
	}
	
}

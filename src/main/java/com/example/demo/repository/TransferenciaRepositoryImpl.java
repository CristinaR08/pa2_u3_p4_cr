package com.example.demo.repository;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		this.entityManager.persist(transferencia);
		//throw new RuntimeException();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Transferencia transferencia) {
		this.entityManager.merge(transferencia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public Transferencia buscar(Integer id) {
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)

	public void eliminar(Integer id) {
		this.entityManager.remove(id);
	}
	

	@Override
	public List<Transferencia> listaTransferencias() {
		TypedQuery<Transferencia> myQuery = this.entityManager.createQuery("SELECT t FROM Transferencia t",Transferencia.class);
		List<Transferencia> listaTransferencia = myQuery.getResultList();
		for(Transferencia t: listaTransferencia) {
			t.getCuentaBancariaOrigen();
		}
		return listaTransferencia;
	}



}

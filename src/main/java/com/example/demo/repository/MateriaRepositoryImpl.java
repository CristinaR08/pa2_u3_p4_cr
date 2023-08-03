package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	public Materia buscarCodigo(String codigo) {
		return this.entityManager.find(Materia.class, codigo);
	}

	@Override
	public List<Materia> listaMaterias() {
		TypedQuery<Materia> myQuery = this.entityManager.createQuery("SELECT m FROM Materia m",Materia.class);
		List<Materia> listaMaterias = myQuery.getResultList();
		for(Materia mat: listaMaterias) {
			if (true) { 
	            System.out.println(mat.getCodigo());
	        }
		}
		return listaMaterias;
		
	}
	
	
	
}

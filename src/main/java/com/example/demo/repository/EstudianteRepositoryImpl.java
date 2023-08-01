package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public Estudiante buscarCedula(String cedula) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula=:datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}


}

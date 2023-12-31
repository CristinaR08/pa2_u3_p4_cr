package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements  IHotelRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		//SELECT * FROM Hotel h JOIN habitacion ha on h.htl_id = ha.habi_id_hotel
		//SELECT h FROM Hotel h JOIN h.habitaciones ha //no es necesario el ON porque ya esta hecho match
		//colocamos la relacion que hace referencia a habitaciones 
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",Hotel.class);
		return myQuery.getResultList();
	}

	@Override
	public void agregar(Hotel hotel) {
		this.entityManager.persist(hotel);
		
	}

	
}

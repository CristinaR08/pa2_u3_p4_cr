package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Habitacion;
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
	public void insertar(Hotel hotel) {
		this.entityManager.persist(hotel);
		
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.entityManager.merge(hotel);
		
	}

	@Override
	public Hotel buscar(Integer id) {
		return this.entityManager.find(Hotel.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
		
	}
	
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		//SELECT * FROM Hotel h JOIN habitacion ha on h.htl_id = ha.habi_id_hotel
		//SELECT h FROM Hotel h JOIN h.habitaciones ha //no es necesario el ON porque ya esta hecho match
		//colocamos la relacion que hace referencia a habitaciones 
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",Hotel.class); //JOIN e INNER JOIN son lo mismo, solo es abreviacion
		List<Hotel> listaHoteles = myQuery.getResultList();
		for(Hotel h: listaHoteles) {
			h.getHabitaciones().size();
		}
		return listaHoteles;
		
		//SELECT d* FROM Facturas inner join detalle d on f.fact_id = d.deta_id_fact
		//SELECT d FROM Facturas f JOIN f.detalles d
	}

	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		//SELECT h.* FROM public.hotel h right join habitacion ha on h.htl_id = ha.habi_id_hotel
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",Hotel.class); //sacan los datos de habitaciones (TablaA)
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterLefttJoin() {
		//SELECT h.* FROM public.hotel h left join habitacion ha on h.htl_id = ha.habi_id_hotel
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class); //sacan los datos de Hotel (TablaB)
		return myQuery.getResultList();
	}

	@Override
	public List<Habitacion> seleccionarHabitacionOuterLefttJoin() {
		TypedQuery<Habitacion> myQuery = this.entityManager.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha",Habitacion.class); 
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",Hotel.class); 
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarWhereJoin() {
		//		SELECT h.* FROM hotel h , habitacion ha WHERE h.htl_id = ha.habi_id_hotel
		//JPQL//SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel //de habitacion el atributo que me da el hotel es ha.hotel
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h=ha.hotel",Hotel.class); 
		return myQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarFetchJoin() {
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha",Hotel.class); //JOIN e INNER JOIN son lo mismo, solo es abreviacion
		return myQuery.getResultList();
	}

}

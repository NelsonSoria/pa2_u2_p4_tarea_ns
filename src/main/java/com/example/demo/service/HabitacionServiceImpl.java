package com.example.demo.service;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class HabitacionServiceImpl implements HabitacionService{
     
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void guardar(Habitacion habitacion) {
		this.entityManager.persist(habitacion);
		
	}

	@Override
	public void borrar(Integer id) {
		Habitacion habEncontrado = this.buscarPorID(id);
		this.entityManager.remove(habEncontrado);
		
	}

	@Override
	public Habitacion buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Habitacion.class, id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.entityManager.merge(habitacion);
		
	}

}

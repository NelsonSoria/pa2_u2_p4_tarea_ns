package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class AutorRespositoryImpl implements AutorRespository{
	  
		@PersistenceContext
		private EntityManager entityManager;
		
	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(autor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Autor autorEncontrado = this.seleccionarPorID(id);
		this.entityManager.remove(autorEncontrado);
	}

	@Override
	public Autor seleccionarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Autor.class, id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub	this.entityManager.merge(habitacion);
		this.entityManager.merge(autor);
		
	}

}

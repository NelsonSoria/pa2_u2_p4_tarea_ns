package com.example.demo.respository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class LibroRespositoryImpl implements LibroRespository{
	 
	@PersistenceContext
	private EntityManager entityManager;
	
@Override
public void insertar(Libro libro) {
	// TODO Auto-generated method stub
	this.entityManager.persist(libro);
}

@Override
public void eliminar(Integer id) {
	// TODO Auto-generated method stub
	Libro libroEncontrado = this.seleccionarPorID(id);
	this.entityManager.remove(libroEncontrado);
}

@Override
public Libro seleccionarPorID(Integer id) {
	// TODO Auto-generated method stub
	return this.entityManager.find(Libro.class, id);
}

@Override
public void actualizar(Libro  libro) {
	// TODO Auto-generated method stub
	this.entityManager.merge(libro);
	
}

}

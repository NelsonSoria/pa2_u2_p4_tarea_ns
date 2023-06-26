package com.example.demo.respository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional 
public class EstudianteRespositoryImpl implements EstudianteRespository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estu) {
	   this.entityManager.persist(estu);
		
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estuEncontrado=this.seleccionarPorCD(cedula);
		this.entityManager.remove(estuEncontrado);
		
	}

	@Override
	public Estudiante seleccionarPorCD(String cedula) {
		return this.entityManager.find(Estudiante.class, cedula);//.class para decir con que va a trabajar el metodo
	}

	@Override
	public void actualizar(Estudiante estu) {
		this.entityManager.merge(estu);
	
	}

	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_apellido =
		//JPQL
		//SELECT e FROM Estudiante e WHERE e.apllido=
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante seleccionarPorApellidoYNombre(String apellido, String nombre) {

		Query myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido AND e.nombre= :datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido= :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

}

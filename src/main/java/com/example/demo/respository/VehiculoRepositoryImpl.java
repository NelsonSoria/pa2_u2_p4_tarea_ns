package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class VehiculoRepositoryImpl  implements VehiculoRepository{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void eliminar(int id) {
		Vehiculo vehiEncontrado= this.seleccionarPorID(id);
		this.entityManager.remove(vehiEncontrado);
		
	}

	@Override
	public Vehiculo seleccionarPorID(int id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class,id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.entityManager.merge(vehiculo);
		
	}

	@Override
	public Vehiculo seleccionarPorMarcaModeloYColor(String marca, String modelo, String color) {
		Query myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca= :datoMarca AND v.modelo=:datoModelo AND v.color=:datoColor");
		myQuery.setParameter("datoMarca",marca);
		myQuery.setParameter("datoModelo",modelo);
		myQuery.setParameter("datoColor",color);
		return (Vehiculo) myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> seleccionarListaPorColorYMayorIgualQueFecha(String color, LocalDate fechaFabricacion) {
		Query myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.color=:datoColor AND v.fechaFabricacion>= :datoFechaFabricacion");
		myQuery.setParameter("datoColor", color);
		myQuery.setParameter("datoFechaFabricacion", fechaFabricacion);
		return myQuery.getResultList();
	}

	@Override
	public Vehiculo seleccionarPorMarcaYModeloTyped(String marca, String modelo) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.marca= :datoMarca AND v.modelo=:datoModelo", Vehiculo.class);
		myQuery.setParameter("datoMarca",marca);
		myQuery.setParameter("datoModelo",modelo);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> seleccionarListaPorMenorIgualDePrecioTyped(BigDecimal precio) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.precio <= :datoPrecio",Vehiculo.class);
		myQuery.setParameter("datoPrecio", precio);
		return myQuery.getResultList();
	}
	
}

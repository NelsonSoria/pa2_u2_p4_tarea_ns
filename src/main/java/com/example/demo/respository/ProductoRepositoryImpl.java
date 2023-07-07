package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProductoRepositoryImpl implements ProductoRepository{

	@PersistenceContext
	private  EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);
		
	}

	@Override
	public void eliminar(int id) {
	  Producto p= this.seleccionarPorID(id);
	  this.entityManager.remove(p);
		
	}

	@Override
	public Producto seleccionarPorID(int id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
		
	}

	@Override
	public List<Producto> seleccionarProductosDinamico(LocalDateTime fecha, Integer stock,
			BigDecimal precio) {
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Producto> myCriteriAQuery= myBuilder.createQuery(Producto.class);
		Root<Producto> miTablaFrom = myCriteriAQuery.from(Producto.class);

		//evaluar si la fecha>fechaActual, utilice el AND para buscar stock >? y precio <?
	    //si no utilice OR
				
		//fecha>LocalDateTime.now() p.stock>? AND e.precio <?
		//fecha<=LocalDateTime.now() p.stock>? OR e.precio <?

		// p.stock>?
		Predicate pStock= myBuilder.greaterThanOrEqualTo(miTablaFrom.get("stock"), stock);

		//e.precio <?
		Predicate pPrecio= myBuilder.lessThanOrEqualTo(miTablaFrom.get("precio"), precio);

		Predicate predicadoFinal=null;
		if(fecha.isAfter(LocalDateTime.now())) {
			predicadoFinal= myBuilder.or(pStock,pPrecio);
		}else {
			predicadoFinal= myBuilder.and(pStock,pPrecio);
		}
		myCriteriAQuery.select(miTablaFrom).where(predicadoFinal);

		TypedQuery<Producto> myQueryFinal = this.entityManager.createQuery(myCriteriAQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public int eliminarPorFechaVencimiento(LocalDateTime fecha) {
		Query miQuery = this.entityManager.createQuery("DELETE FROM Producto p Where p.fechaVencimiento>=:datoFecha");
		miQuery.setParameter("datoFecha", fecha);

		//numero de registros afectados
		return miQuery.executeUpdate();
	}

	

	@Override
	public int actualizarPorIntervaloFechaFabricacion(Integer stock, LocalDateTime fechaFabricacionInicio,
			LocalDateTime fechaFabricacionFin) {
		Query miQuery = this.entityManager.createQuery("UPDATE Producto p SET p.stock=:datoStock WHERE p.fechaFabricacion"
				+ " BETWEEN :datoFechaFabricacionInicio AND :datoFechaFabricacionFin ");
		miQuery.setParameter("datoStock",stock);
		miQuery.setParameter("datoFechaFabricacionInicio",  fechaFabricacionInicio);
		miQuery.setParameter("datoFechaFabricacionFin",  fechaFabricacionFin);
	    return	miQuery.executeUpdate();
	}
	

}

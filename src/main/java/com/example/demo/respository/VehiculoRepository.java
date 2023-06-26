package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface VehiculoRepository {
	public void insertar(Vehiculo vehiculo);
	public void eliminar(int id);
	public Vehiculo seleccionarPorID(int id);
	public void actualizar(Vehiculo vehiculo);
	
	
	public Vehiculo seleccionarPorMarcaModeloYColor(String marca,String modelo,String color);
	public List<Vehiculo> seleccionarListaPorColorYMayorIgualQueFecha(String color, LocalDate fechaFabricacion);
	
	public Vehiculo seleccionarPorMarcaYModeloTyped(String marca,String modelo);
	public  List<Vehiculo> seleccionarListaPorMenorIgualDePrecioTyped(BigDecimal precio);
	

}

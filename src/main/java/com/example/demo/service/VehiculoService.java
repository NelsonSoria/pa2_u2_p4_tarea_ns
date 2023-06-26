package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface VehiculoService {
	public void guardar(Vehiculo vehiculo);
	public void borrar(int id);
	public Vehiculo buscarPorID(int id);
	public void actualizar(Vehiculo vehiculo);
	
	
	public Vehiculo buscarPorMarcaModeloYColor(String marca,String modelo,String color);
	public List<Vehiculo> reporteListaPorColorYMayorIgualQueFecha(String color, LocalDate fechaFabricacion);
	
	public Vehiculo buscarPorMarcaYModeloTyped(String marca,String modelo);
	public  List<Vehiculo> reporteListaPorMenorIgualDePrecio(BigDecimal precio);
}

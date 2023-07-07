package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoService {
	public void guardar(Producto producto);
	public void borrar(int id);
	public Producto buscarPorID(int id);
	public void actualizar(Producto producto);
	
	
	public List<Producto> buscarProductosDinamico(LocalDateTime fecha,Integer stock,BigDecimal precio);
	
	public int borrarPorFechaVencimiento(LocalDateTime fecha);
	
	
	public int borrarPorIntervaloFechaFabricacion(Integer stock,LocalDateTime fechaFabricacionInicio,LocalDateTime fechaFabricacionFin);

}

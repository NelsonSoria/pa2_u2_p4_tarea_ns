package com.example.demo.respository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Producto;

public interface ProductoRepository {
	
	public void insertar(Producto producto);
	public void eliminar(int id);
	public Producto seleccionarPorID(int id);
	public void actualizar(Producto producto);
	
	public List<Producto> seleccionarProductosDinamico(LocalDateTime fecha,Integer stock,BigDecimal precio);
	
	public int eliminarPorFechaVencimiento(LocalDateTime fecha);
	
	
	public int actualizarPorIntervaloFechaFabricacion(Integer stock,LocalDateTime fechaFabricacionInicio,LocalDateTime fechaFabricacionFin);

}

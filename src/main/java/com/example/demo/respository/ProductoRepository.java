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
	
	//evaluar si la fecha de vencimientoto >= fecha actual, utilice el AND para buscar stock >10 y precio <3.50,
	//si no utilice OR
	public List<Producto> seleccionarProductosDinamico(LocalDateTime fecha,Integer stock,BigDecimal precio);
	

}

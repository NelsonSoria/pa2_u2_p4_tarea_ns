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
	
	//evaluar si la fecha de vencimientoto >= fecha actual, utilice el AND para buscar stock >10 y precio <3.50,
	//si no utilice OR
	public List<Producto> buscarProductosDinamico(LocalDateTime fecha,Integer stock,BigDecimal precio);

}

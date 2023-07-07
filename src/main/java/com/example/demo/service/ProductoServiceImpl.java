package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.respository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public void guardar(Producto producto) {
		this.productoRepository.insertar(producto);
		
	}

	@Override
	public void borrar(int id) {
		this.productoRepository.eliminar(id);
		
	}

	@Override
	public Producto buscarPorID(int id) {
		// TODO Auto-generated method stub
		return this.productoRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Producto producto) {
		this.productoRepository.actualizar(producto);
		
	}

	@Override
	public List<Producto> buscarProductosDinamico(LocalDateTime fecha, Integer stock, BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.productoRepository.seleccionarProductosDinamico(fecha, stock, precio);
	}

}

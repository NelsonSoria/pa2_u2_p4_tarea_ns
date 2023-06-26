package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.respository.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService{

	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	@Override
	public void guardar(Vehiculo vehiculo) {
		this.vehiculoRepository.insertar(vehiculo);
		
	}

	@Override
	public void borrar(int id) {
	this.vehiculoRepository.eliminar(id);
		
	}

	@Override
	public Vehiculo buscarPorID(int id) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.vehiculoRepository.actualizar(vehiculo);
		
	}

	@Override
	public Vehiculo buscarPorMarcaModeloYColor(String marca, String modelo, String color) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorMarcaModeloYColor(marca, modelo, color);
	}

	@Override
	public List<Vehiculo> reporteListaPorColorYMayorIgualQueFecha(String color, LocalDate fechaFabricacion) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarListaPorColorYMayorIgualQueFecha(color, fechaFabricacion);
	}

	@Override
	public Vehiculo buscarPorMarcaYModeloTyped(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarPorMarcaYModeloTyped(marca, modelo);
	}

	@Override
	public List<Vehiculo> reporteListaPorMenorIgualDePrecio(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.vehiculoRepository.seleccionarListaPorMenorIgualDePrecioTyped(precio);
	}
	

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Hotel;

import com.example.demo.respository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public void guardar(Hotel hotel) {
		this.hotelRepository.insertar(hotel);
		
	}

	@Override
	public void borrar(int id) {
		this.hotelRepository.eliminar(id);
		
	}

	@Override
	public Hotel buscarPorID(int id) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Hotel hotel) {
		this.hotelRepository.actualizar(hotel);
		
	}

	

}

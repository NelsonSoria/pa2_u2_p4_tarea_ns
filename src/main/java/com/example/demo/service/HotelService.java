package com.example.demo.service;

import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	public void guardar(Hotel hotel);
	public void borrar(int id);
	public Hotel buscarPorID(int id);
	public void actualizar(Hotel hotel);

}

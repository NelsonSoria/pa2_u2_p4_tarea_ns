package com.example.demo.service;


import com.example.demo.repository.modelo.Hotel;

public interface HotelService {
	public void guardar(Hotel hotel);
	public void borrar(Integer id);
	public Hotel buscarPorID(Integer id);
	public void actualizar(Hotel hotel);

}

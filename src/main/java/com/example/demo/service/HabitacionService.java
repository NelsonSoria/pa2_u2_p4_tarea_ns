package com.example.demo.service;

import com.example.demo.repository.modelo.Habitacion;

public interface HabitacionService {
	public void guardar(Habitacion habitacion);
	public void borrar(int id);
	public Habitacion buscarPorID(int id);
	public void actualizar(Habitacion habitacion);

}

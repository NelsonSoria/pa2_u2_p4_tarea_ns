package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.respository.HabitacionRepository;

@Service
public class HabitacionServiceImpl implements HabitacionService{
	
	@Autowired
	private HabitacionRepository habitacionRepository;

	@Override
	public void guardar(Habitacion habitacion) {
		this.habitacionRepository.insertar(habitacion);
		
	}

	@Override
	public void borrar(int id) {
		this.habitacionRepository.eliminar(id);
		
	}

	@Override
	public Habitacion buscarPorID(int id) {
		// TODO Auto-generated method stub
		return this.habitacionRepository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Habitacion habitacion) {
		this.habitacionRepository.actualizar(habitacion);
		
	}

}

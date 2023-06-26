package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Libro;
import com.example.demo.respository.LibroRespository;

@Service

public class LibroServiceImpl implements LibroService{
	 @Autowired
	 private LibroRespository libroRespository;

	@Override
	public void guardar(Libro libro) {
		// TODO Auto-generated method stub
		this.libroRespository.insertar(libro);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.libroRespository.eliminar(id);
	}

	@Override
	public Libro buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.libroRespository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		this.libroRespository.actualizar(libro);
	}


}

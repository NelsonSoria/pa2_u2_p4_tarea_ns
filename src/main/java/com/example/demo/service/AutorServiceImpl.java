package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.respository.AutorRespository;


@Service
public class AutorServiceImpl implements AutorService{

	
	@Autowired
	private AutorRespository autorRespository;
	@Override
	public void guardar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRespository.insertar(autor);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRespository.eliminar(id);
	}

	@Override
	public Autor buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRespository.seleccionarPorID(id);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRespository.actualizar(autor);
	}
	  
}

package com.example.demo.service;

import com.example.demo.repository.modelo.Autor;


public interface AutorService {
	public void guardar(Autor autor);
	public void borrar(Integer id);
	public Autor buscarPorID(Integer id);
	public void actualizar(Autor autor);

}

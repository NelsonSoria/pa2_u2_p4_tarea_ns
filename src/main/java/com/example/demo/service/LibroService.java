package com.example.demo.service;

import com.example.demo.repository.modelo.Libro;

public interface LibroService {
	public void guardar(Libro libro);
	public void borrar(Integer id);
	public Libro buscarPorID(Integer id);
	public void actualizar(Libro libro);

}

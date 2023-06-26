package com.example.demo.respository;

import com.example.demo.repository.modelo.Libro;

public interface LibroRespository {
	public void insertar(Libro libro);
	public void eliminar(Integer id);
	public Libro seleccionarPorID(Integer id);
	public void actualizar(Libro libro);

}

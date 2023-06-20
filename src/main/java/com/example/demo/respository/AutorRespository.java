package com.example.demo.respository;

import com.example.demo.repository.modelo.Autor;


public interface AutorRespository {
	public void insertar(Autor autor);
	public void eliminar(Integer id);
	public Autor seleccionarPorID(Integer id);
	public void actualizar(Autor autor);

}

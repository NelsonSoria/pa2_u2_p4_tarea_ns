package com.example.demo.respository;

import java.util.List;

import com.example.demo.repository.modelo.Estudiante;

public interface EstudianteRespository {
	public void insertar(Estudiante estu);
	public void eliminar(String cedula);
	public Estudiante seleccionarPorCD(String cedula);
	public void actualizar(Estudiante estu);
	
	public Estudiante seleccionarPorApellido(String apellido);
	
	public List<Estudiante> seleccionarListaPorApellido(String apellido);
	public Estudiante seleccionarPorApellidoYNombre(String apellido,String nombre);
	
	public Estudiante seleccionarPorApellidoTyped(String apellido);
}

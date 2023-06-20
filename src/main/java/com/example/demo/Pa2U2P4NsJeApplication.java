package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Autor;
import com.example.demo.repository.modelo.Libro;
import com.example.demo.service.AutorService;
import com.example.demo.service.LibroService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private AutorService autorService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Libro miLibro1= new Libro();
		miLibro1.setTitulo("Juventud");
		miLibro1.setEditorial("Acantilado");
	
		Libro miLibro2= new Libro();
		miLibro2.setTitulo("  verano");
		miLibro2.setEditorial("Aguilar");
		
		Libro miLibro3= new Libro();
		miLibro3.setTitulo(" Marte");
		miLibro3.setEditorial("Alianza");
		
		
		Autor miAutor1 = new Autor();
		miAutor1.setNombre("Dayana");
		miAutor1.setApellido("Parra");
		
		Autor miAutor2 = new Autor();
		miAutor2.setNombre("Perez");
		miAutor2.setApellido("pepito");
		
		Autor miAutor3 = new Autor();
		miAutor3.setNombre("Eduardo");
		miAutor3.setApellido("sandoval");
		
		Autor miAutor4 = new Autor();
		miAutor4.setNombre("Damian");
		miAutor4.setApellido("Suarez");
		
		Set<Libro> misLibros = new HashSet<>();
		misLibros.add(miLibro2);
		misLibros.add(miLibro3);
		
		Set<Autor> misAutores = new HashSet<>();
		misAutores.add(miAutor1);
		misAutores.add(miAutor2);
		misAutores.add(miAutor3);
		
		
		//misAutores2.add(miAutor2);
		miLibro1.setAutores(misAutores);
		miAutor4.setLibros(misLibros);
	
	    this.libroService.guardar(miLibro1);
		this.autorService.guardar(miAutor4);
		
		Autor autorEcontrado= this.autorService.buscarPorID(1);
		System.out.println(autorEcontrado);
		autorEcontrado.setApellido("Santilla");
		this.autorService.actualizar(autorEcontrado);
		
		Libro libroEcontrado= this.libroService.buscarPorID(1);
		System.out.println(libroEcontrado);
		libroEcontrado.setEditorial("Aka");
		this.autorService.actualizar(autorEcontrado);
		
		this.libroService.borrar(2);
		this.libroService.borrar(3);
		this.autorService.borrar(4);
		
		
	}

}

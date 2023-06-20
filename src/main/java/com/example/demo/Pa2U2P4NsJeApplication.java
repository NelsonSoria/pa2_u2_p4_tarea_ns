package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private CiudadanoService ciudadanoService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Ciudadano ciud3 = new Ciudadano();
		ciud3.setApellido("Paredes3");
		ciud3.setCedula("13432413");
		ciud3.setNombre("Nelson3");
		
		Ciudadano ciud2 = new Ciudadano();
		ciud2.setApellido("Soria4");
		ciud2.setCedula("4543533");
		ciud2.setNombre("Nelson4");
		
		
		Empleado empl3 = new Empleado();
		empl3.setCargo("Ventas2");
		empl3.setSueldo(new BigDecimal(434));
		
		Empleado empl4 = new Empleado();
		empl4.setCargo("Administracion2");
	  	empl4.setSueldo(new BigDecimal(323));
		
	   	
		 ciud3.setEmpleado(empl3);
		 empl4.setCiudadano(ciud2);
	
		 this.ciudadanoService.guardar(ciud3);
		 
	     //this.empleadoService.guardar(empl4);

		Empleado emplencontrado= this.empleadoService.buscarPorID(2);	
		System.out.println(emplencontrado);
		
		emplencontrado.setCargo("Jefe");
		this.empleadoService.actualizar(emplencontrado);
		this.empleadoService.borrar(3);
	 
		
		
	}

}

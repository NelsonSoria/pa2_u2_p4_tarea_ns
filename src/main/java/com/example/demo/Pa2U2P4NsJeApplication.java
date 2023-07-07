package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Producto;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.ProductoService;
import com.example.demo.service.VehiculoService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private ProductoService productoService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//CREACION DE PRODUCTOS
		Producto p1= new Producto();
		p1.setCodigo("A003");
		p1.setNombre("Atun");
		p1.setPrecio(new BigDecimal(1.24));
		p1.setFechaFabricacion(LocalDateTime.of(2021,5,7,2,3));
		p1.setFechaVencimiento(LocalDateTime.of(2023,4,13,5,3));
		p1.setStock(15);

		//productoService.guardar(p1);
		
		int n=this.productoService.borrarPorIntervaloFechaFabricacion(10, LocalDateTime.of(2021,01,1,1,5), LocalDateTime.of(2021,12,30,3,4));
		System.err.println(n);
		int n1=this.productoService.borrarPorFechaVencimiento(LocalDateTime.now());
		System.err.println(n);
		
	}

}

package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.VehiculoService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private VehiculoService vehiculoservice;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Vehiculo v1 = new Vehiculo();
		v1.setColor("Azul");
		v1.setMarca("Chevrolet");
		v1.setModelo("Aveo");
		v1.setPrecio(new BigDecimal(10000));
		v1.setFechaFabricacion(LocalDate.of(2015, 1, 10));
		// this.vehiculoservice.guardar(v1);

		// Ejemplo de Query con single result
		Vehiculo vEncontrado1 = this.vehiculoservice.buscarPorMarcaModeloYColor("BMW", "Serie3", "Negro");
		System.out.println(vEncontrado1);
		
		
		// Ejemplo de Query con result list
		List<Vehiculo> misVehiculos = this.vehiculoservice.reporteListaPorColorYMayorIgualQueFecha("Negro",
				LocalDate.of(2010, 1, 1));
		for (Vehiculo v : misVehiculos) {
			System.out.println(v);
		}
		
		//Ejemplo de TypedQuery con single result
		Vehiculo vEncontrado2 = this.vehiculoservice.buscarPorMarcaYModeloTyped("Chevrolet", "Aveo");
		System.out.println(vEncontrado2);

		//Ejemplo de TypedQuery con result list
		List<Vehiculo> misVehiculos2 = this.vehiculoservice.reporteListaPorMenorIgualDePrecio(new BigDecimal(50000));
		for (Vehiculo v : misVehiculos2) {
			System.out.println(v);
		}

	}

}

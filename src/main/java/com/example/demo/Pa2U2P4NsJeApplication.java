package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Ciudadano;
import com.example.demo.repository.modelo.Empleado;
import com.example.demo.repository.modelo.Habitacion;
import com.example.demo.repository.modelo.Hotel;
import com.example.demo.service.CiudadanoService;
import com.example.demo.service.EmpleadoService;
import com.example.demo.service.HabitacionService;
import com.example.demo.service.HotelService;

@SpringBootApplication
public class Pa2U2P4NsJeApplication implements CommandLineRunner {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4NsJeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Hotel hot1= new Hotel();
		hot1.setDireccion("Pasaje.Simon");
		hot1.setNombre("ecu");
		
		Habitacion hab1= new Habitacion();
		hab1.setNumero("10");
		hab1.setValor(new BigDecimal(70));
		
		Habitacion hab2= new Habitacion();
		hab2.setNumero("11");
		hab2.setValor(new BigDecimal(2000));
		
		List<Habitacion> misHabitaciones = new ArrayList<>();
		misHabitaciones.add(hab1);
		misHabitaciones.add(hab2);
		
		hot1.setHabitaciones(misHabitaciones);
		
		this.hotelService.guardar(hot1); 
	
		
		Habitacion hab10= new Habitacion();
		hab10.setNumero("12");
		hab10.setValor(new BigDecimal(700));
		
		Hotel hot10= new Hotel();
		hot10.setDireccion("Av.Colon");
		hot10.setNombre(" Crillon");
		
		hab10.setHotel(hot10);
		this.habitacionService.guardar(hab10);
		
		Habitacion habiEntontrado= this.habitacionService.buscarPorID(3);	
		System.out.println(habiEntontrado);
		
		habiEntontrado.setNumero("32");
		
		this.habitacionService.actualizar(habiEntontrado);
		this.habitacionService.borrar(3);
		this.habitacionService.borrar(4);
		this.hotelService.borrar(2);
		
	}

}

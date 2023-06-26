package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Vehiculo {
	
	@GeneratedValue(generator = "seq_vehiculo",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_vehiculo",sequenceName ="seq_vehiculo",allocationSize = 1 )
	@Id
	@Column(name="vehi_id")
	private Integer id;
	
	@Column(name="vehi_marca")
	private String marca;
	
	@Column(name="vehi_modelo")
	private String modelo;
	
	@Column(name="vehi_color")
	private String color;
	
	@Column(name="vehi_precio")
	private BigDecimal precio;
	
	@Column(name="vehi_fechafabricacion")
	private LocalDate fechaFabricacion;
	
	//SET Y GET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio="
				+ precio + ", fechaFabricacion=" + fechaFabricacion + "]";
	}
	
	

}

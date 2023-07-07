package com.example.demo.repository.modelo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Producto {
	@GeneratedValue(generator = "seq_producto",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_producto",sequenceName ="seq_producto",allocationSize = 1 )
	@Id
	@Column(name="prod_id")
	private Integer id;
	
	@Column(name="prod_codigo")
	private String codigo;
	
	@Column(name="prod_nombre")
	private String nombre;
	
	@Column(name="prod_stock")
	private Integer stock;
	
	@Column(name="prod_precio")
	private BigDecimal precio;
	
	@Column(name="prod_fecha_fabricacion")
	private LocalDateTime fechaFabricacion;
	
	@Column(name="prod_fecha_vencimiento")
	private LocalDateTime  fechaVencimiento;

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", precio="
				+ precio + ", fechaFabricacion=" + fechaFabricacion + ", fechaVencimiento=" + fechaVencimiento + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDateTime getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public LocalDateTime getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

}

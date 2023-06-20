package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity

@Table(name="empleado")

public class Empleado {
	

	@GeneratedValue(generator = "seq_empleado",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_empleado",sequenceName ="seq_empleado",allocationSize = 1 )
	@Id
	@Column(name="empl_id")
	private Integer id;
	
	@Column(name="empl_sueldo")
	private BigDecimal sueldo;
	
	@Column(name="empl_cargo")
	private String cargo;
	
	@OneToOne(cascade = CascadeType.ALL)//sobre la entidad principal, voy a afectar en cascada al otro atributo
	@JoinColumn(name = "empl_ciudadano_id")
	private Ciudadano ciudadano;
	
	//set y get
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", sueldo=" + sueldo + ", cargo=" + cargo + "]";
	}
	
}

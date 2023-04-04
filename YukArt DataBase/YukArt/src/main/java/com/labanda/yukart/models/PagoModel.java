package com.labanda.yukart.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pago")
public class PagoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	
	private Long id;
	private String nombre_tarjeta;
	private String numero_tarjeta;
	private String fecha_vencimiento;
	private String cvv;
	
	@ManyToOne
	private DireccionEnvioModel direccion_envio;
	
	public PagoModel() {
		super();
	}

	public PagoModel(Long id, String nombre_tarjeta, String numero_tarjeta, String fecha_vencimiento, String cvv) {
		super();
		this.id = id;
		this.nombre_tarjeta = nombre_tarjeta;
		this.numero_tarjeta = numero_tarjeta;
		this.fecha_vencimiento = fecha_vencimiento;
		this.cvv = cvv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_tarjeta() {
		return nombre_tarjeta;
	}

	public void setNombre_tarjeta(String nombre_tarjeta) {
		this.nombre_tarjeta = nombre_tarjeta;
	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
}

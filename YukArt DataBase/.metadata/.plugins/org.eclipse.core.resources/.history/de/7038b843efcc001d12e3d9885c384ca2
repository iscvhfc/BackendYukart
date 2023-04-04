package com.labanda.yukart.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrito_productos")
public class CarritoProductoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	
	private Long id;
	private float precio;
	private Integer cantidad;
	
	@OneToOne
	private CarritoComprasModel carrito_compras;
	
	@OneToOne
    private ProductosModel producto;
	
	public CarritoProductoModel() {
		super();
	}

	public CarritoProductoModel(Long id, float precio, Integer cantidad) {
		super();
		this.id = id;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	
}

package com.labanda.yukart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labanda.yukart.models.CarritoProductoModel;
import com.labanda.yukart.services.CarritoProductoService;

@RestController
@RequestMapping("/carrito-productos")
public class CarritoProductoController {
	
	@Autowired
	private CarritoProductoService carritoProductoService;

	@GetMapping
	public ResponseEntity<List<CarritoProductoModel>> listarCarritoProductos() {
		List<CarritoProductoModel> carritoProductos = carritoProductoService.listarCarritoProductos();
		return new ResponseEntity<>(carritoProductos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarritoProductoModel> obtenerCarritoProducto(@PathVariable Long id) {
		CarritoProductoModel carritoProducto = carritoProductoService.obtenerCarritoProducto(id);
		if (carritoProducto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(carritoProducto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> guardarCarritoProducto(@RequestBody CarritoProductoModel carritoProducto) {
		carritoProductoService.guardarCarritoProducto(carritoProducto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizarCarritoProducto(@PathVariable Long id, @RequestBody CarritoProductoModel carritoProducto) {
		carritoProductoService.actualizarCarritoProducto(id, carritoProducto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCarritoProducto(@PathVariable Long id) {
		carritoProductoService.eliminarCarritoProducto(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

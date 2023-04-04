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

import com.labanda.yukart.models.ProductosModel;
import com.labanda.yukart.services.ProductosService;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
	
	@Autowired
	private ProductosService productosService;

	@GetMapping
	public List<ProductosModel> listarProductos() {
		return productosService.listarProductos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductosModel> obtenerProducto(@PathVariable Long id) {
		ProductosModel producto = productosService.obtenerProducto(id);
		if (producto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(producto);
	}

	@PostMapping
	public ResponseEntity<ProductosModel> guardarProducto(@RequestBody ProductosModel producto) {
		productosService.guardarProducto(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(producto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductosModel> actualizarProducto(@PathVariable Long id, @RequestBody ProductosModel producto) {
		productosService.actualizarProducto(id, producto);
		return ResponseEntity.ok(producto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
		productosService.eliminarProducto(id);
		return ResponseEntity.noContent().build();
	}

}

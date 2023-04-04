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

import com.labanda.yukart.models.CarritoComprasModel;
import com.labanda.yukart.services.CarritoComprasService;

@RestController
@RequestMapping("/carritoscompras")
public class CarritoComprasController {
	
	@Autowired
	private CarritoComprasService carritoComprasService;

	@GetMapping("")
	public ResponseEntity<List<CarritoComprasModel>> listarCarritosCompras() {
		List<CarritoComprasModel> carritosCompras = carritoComprasService.listarCarritosCompras();
		return ResponseEntity.ok(carritosCompras);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarritoComprasModel> obtenerCarritoCompras(@PathVariable("id") Long id) {
		CarritoComprasModel carritoCompras = carritoComprasService.obtenerCarritoCompras(id);
		if (carritoCompras == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carritoCompras);
	}

	@PostMapping("")
	public ResponseEntity<CarritoComprasModel> guardarCarritoCompras(@RequestBody CarritoComprasModel carritoCompras) {
		carritoComprasService.guardarCarritoCompras(carritoCompras);
		return ResponseEntity.status(HttpStatus.CREATED).body(carritoCompras);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarritoComprasModel> actualizarCarritoCompras(@PathVariable("id") Long id, @RequestBody CarritoComprasModel carritoCompras) {
		carritoComprasService.actualizarCarritoCompras(id, carritoCompras);
		return ResponseEntity.ok(carritoCompras);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCarritoCompras(@PathVariable("id") Long id) {
		CarritoComprasModel carritoCompras = carritoComprasService.obtenerCarritoCompras(id);
		if (carritoCompras == null) {
			return ResponseEntity.notFound().build();
		}
		carritoComprasService.eliminarCarritoCompras(id);
		return ResponseEntity.noContent().build();
	}
	
}

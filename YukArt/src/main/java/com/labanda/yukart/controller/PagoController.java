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

import com.labanda.yukart.models.PagoModel;
import com.labanda.yukart.services.PagoService;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	
	@GetMapping
	public ResponseEntity<List<PagoModel>> listarPagos() {
		List<PagoModel> pagos = pagoService.listarPagos();
		return new ResponseEntity<>(pagos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PagoModel> obtenerPago(@PathVariable Long id) {
		PagoModel pago = pagoService.obtenerPago(id);
		if (pago == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(pago, HttpStatus.OK);
		}
	}
	
	@PostMapping
	public ResponseEntity<PagoModel> guardarPago(@RequestBody PagoModel pago) {
		pagoService.guardarPago(pago);
		return new ResponseEntity<>(pago, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PagoModel> actualizarPago(@PathVariable Long id, @RequestBody PagoModel pago) {
		pagoService.actualizarPago(id, pago);
		return new ResponseEntity<>(pago, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> eliminarPago(@PathVariable Long id) {
		pagoService.eliminarPago(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
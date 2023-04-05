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

import com.labanda.yukart.models.DireccionEnvioModel;
import com.labanda.yukart.services.DireccionEnvioService;

@RestController
@RequestMapping("/direccion_envio")
public class DireccionEnvioController {

	@Autowired
	private DireccionEnvioService direccionEnvioService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<DireccionEnvioModel>> listarDireccionEnvio() {
		List<DireccionEnvioModel> listaDireccionEnvio = direccionEnvioService.listarDireccionesEnvio();
		return ResponseEntity.ok(listaDireccionEnvio);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<DireccionEnvioModel> obtenerDireccionEnvio(@PathVariable Long id) {
		DireccionEnvioModel direccionEnvio = direccionEnvioService.obtenerDireccionEnvio(id);
		if (direccionEnvio != null) {
			return ResponseEntity.ok(direccionEnvio);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardarDireccionEnvio(@RequestBody DireccionEnvioModel direccionEnvio) {
		direccionEnvioService.guardarDireccionEnvio(direccionEnvio);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Void> actualizarDireccionEnvio(@PathVariable Long id, @RequestBody DireccionEnvioModel direccionEnvio) {
		direccionEnvioService.actualizarDireccionEnvio(id, direccionEnvio);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminarDireccionEnvio(@PathVariable Long id) {
		direccionEnvioService.eliminarDireccionEnvio(id);
		return ResponseEntity.ok().build();
	}
}

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

import com.labanda.yukart.models.CategoriaModel;
import com.labanda.yukart.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<CategoriaModel> listarCategorias() {
		return categoriaService.listarCategorias();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> obtenerCategoria(@PathVariable Long id) {
		CategoriaModel categoria = categoriaService.obtenerCategoria(id);
		if (categoria == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria);
	}

	@PostMapping
	public ResponseEntity<CategoriaModel> guardarCategoria(@RequestBody CategoriaModel categoria) {
		categoriaService.guardarCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaModel> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
		categoriaService.actualizarCategoria(id, categoria);
		return ResponseEntity.ok(categoria);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
		categoriaService.eliminarCategoria(id);
		return ResponseEntity.noContent().build();
	}
}

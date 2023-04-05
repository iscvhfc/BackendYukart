package com.labanda.yukart.controller;

import java.util.ArrayList;
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

import com.labanda.yukart.models.UsuarioModel;
import com.labanda.yukart.repositories.UsuarioRepository;
import com.labanda.yukart.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
		List<UsuarioModel> usuarios = usuarioService.listarUsuarios();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> obtenerUsuario(@PathVariable Long id) {
		UsuarioModel usuario = usuarioService.obtenerUsuario(id);
		if (usuario != null) {
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Void> guardarUsuario(@RequestBody UsuarioModel usuario) {
		usuarioService.guardarUsuario(usuario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuario) {
		usuarioService.actualizarUsuario(id, usuario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
		usuarioService.eliminarUsuario(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

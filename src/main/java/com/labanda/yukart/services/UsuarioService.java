package com.labanda.yukart.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.UsuarioModel;
import com.labanda.yukart.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioModel> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public UsuarioModel obtenerUsuario(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public void guardarUsuario(UsuarioModel usuario) {
		usuarioRepository.save(usuario);
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void actualizarUsuario(Long id, UsuarioModel usuario) {
		UsuarioModel usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente == null) {
			return;
		}
		usuarioExistente.setNombre_usuario(usuario.getNombre_usuario());
		usuarioExistente.setEmail(usuario.getEmail());
		usuarioExistente.setContrasenia(usuario.getContrasenia());
		usuarioRepository.save(usuarioExistente);
	}
}

package com.labanda.yukart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.CategoriaModel;
import com.labanda.yukart.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<CategoriaModel> listarCategorias() {
		return categoriaRepository.findAll();
	}

	public CategoriaModel obtenerCategoria(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	public void guardarCategoria(CategoriaModel categoria) {
		categoriaRepository.save(categoria);
	}

	public void eliminarCategoria(Long id) {
		categoriaRepository.deleteById(id);
	}

	public void actualizarCategoria(Long id, CategoriaModel categoria) {
		CategoriaModel categoriaExistente = categoriaRepository.findById(id).orElse(null);
		if (categoriaExistente == null) {
			return;
		}
		categoriaExistente.setNombre(categoria.getNombre());
		categoriaExistente.setDescripcion(categoria.getDescripcion());
		categoriaRepository.save(categoriaExistente);
	}
}

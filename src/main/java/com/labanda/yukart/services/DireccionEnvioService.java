package com.labanda.yukart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.DireccionEnvioModel;
import com.labanda.yukart.repositories.DireccionEnvioRepository;

@Service
public class DireccionEnvioService {
	
	@Autowired
	private DireccionEnvioRepository direccionEnvioRepository;

	public List<DireccionEnvioModel> listarDireccionesEnvio() {
		return direccionEnvioRepository.findAll();
	}

	public DireccionEnvioModel obtenerDireccionEnvio(Long id) {
		return direccionEnvioRepository.findById(id).orElse(null);
	}

	public void guardarDireccionEnvio(DireccionEnvioModel direccionEnvio) {
		direccionEnvioRepository.save(direccionEnvio);
	}

	public void eliminarDireccionEnvio(Long id) {
		direccionEnvioRepository.deleteById(id);
	}
	
	public void actualizarDireccionEnvio(Long id, DireccionEnvioModel direccionEnvio) {
		DireccionEnvioModel direccionEnvioExistente = direccionEnvioRepository.findById(id).orElse(null);
		if (direccionEnvioExistente == null) {
			return;
		}
		direccionEnvioExistente.setCalle(direccionEnvio.getCalle());
		direccionEnvioExistente.setNumero_exterior(direccionEnvio.getNumero_exterior());
		direccionEnvioExistente.setColonia(direccionEnvio.getColonia());
		direccionEnvioExistente.setCodigo_postal(direccionEnvio.getCodigo_postal());
		direccionEnvioExistente.setCiudad(direccionEnvio.getCiudad());
		direccionEnvioExistente.setEstado(direccionEnvio.getEstado());
		direccionEnvioExistente.setPais(direccionEnvio.getPais());
		direccionEnvioRepository.save(direccionEnvioExistente);
	}

}
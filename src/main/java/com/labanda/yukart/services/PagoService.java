package com.labanda.yukart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.PagoModel;
import com.labanda.yukart.repositories.PagoRepository;

@Service
public class PagoService {
	
	@Autowired
	private PagoRepository pagoRepository;

	public List<PagoModel> listarPagos() {
		return pagoRepository.findAll();
	}

	public PagoModel obtenerPago(Long id) {
		return pagoRepository.findById(id).orElse(null);
	}

	public void guardarPago(PagoModel pago) {
		pagoRepository.save(pago);
	}

	public void eliminarPago(Long id) {
		pagoRepository.deleteById(id);
	}

	public void actualizarPago(Long id, PagoModel pago) {
		PagoModel pagoExistente = pagoRepository.findById(id).orElse(null);
		if (pagoExistente == null) {
			return;
		}
		pagoExistente.setNombre_tarjeta(pago.getNombre_tarjeta());
		pagoExistente.setNumero_tarjeta(pago.getNumero_tarjeta());
		pagoExistente.setFecha_vencimiento(pago.getFecha_vencimiento());
		pagoExistente.setCvv(pago.getCvv());
		pagoRepository.save(pagoExistente);
	}

}

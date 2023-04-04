package com.labanda.yukart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.CarritoComprasModel;
import com.labanda.yukart.repositories.CarritoComprasRepository;

@Service
public class CarritoComprasService {
	
	@Autowired
	private CarritoComprasRepository carritoComprasRepository;

	public List<CarritoComprasModel> listarCarritosCompras() {
		return carritoComprasRepository.findAll();
	}

	public CarritoComprasModel obtenerCarritoCompras(Long id) {
		return carritoComprasRepository.findById(id).orElse(null);
	}

	public void guardarCarritoCompras(CarritoComprasModel carritoCompras) {
		carritoComprasRepository.save(carritoCompras);
	}

	public void eliminarCarritoCompras(Long id) {
		carritoComprasRepository.deleteById(id);
	}

	public void actualizarCarritoCompras(Long id, CarritoComprasModel carritoCompras) {
		CarritoComprasModel carritoComprasExistente = carritoComprasRepository.findById(id).orElse(null);
		if (carritoComprasExistente == null) {
			return;
		}
		carritoComprasExistente.setFecha(carritoCompras.getFecha());
		carritoComprasRepository.save(carritoComprasExistente);
	}

}

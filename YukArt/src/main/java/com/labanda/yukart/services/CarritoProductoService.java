package com.labanda.yukart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.CarritoProductoModel;
import com.labanda.yukart.repositories.CarritoProductoRepository;

@Service
public class CarritoProductoService {
	
	@Autowired
	private CarritoProductoRepository carritoProductoRepository;

	public List<CarritoProductoModel> listarCarritoProductos() {
		return carritoProductoRepository.findAll();
	}

	public CarritoProductoModel obtenerCarritoProducto(Long id) {
		return carritoProductoRepository.findById(id).orElse(null);
	}

	public void guardarCarritoProducto(CarritoProductoModel carritoProducto) {
		carritoProductoRepository.save(carritoProducto);
	}

	public void eliminarCarritoProducto(Long id) {
		carritoProductoRepository.deleteById(id);
	}
	
	public void actualizarCarritoProducto(Long id, CarritoProductoModel carritoProducto) {
		CarritoProductoModel carritoProductoExistente = carritoProductoRepository.findById(id).orElse(null);
		if (carritoProductoExistente == null) {
			return;
		}
		carritoProductoExistente.setPrecio(carritoProducto.getPrecio());
		carritoProductoExistente.setCantidad(carritoProducto.getCantidad());
		carritoProductoRepository.save(carritoProductoExistente);
	}

}

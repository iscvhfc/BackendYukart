package com.labanda.yukart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labanda.yukart.models.ProductosModel;
import com.labanda.yukart.repositories.ProductosRepository;

@Service
public class ProductosService {
	
	@Autowired
	private ProductosRepository productosRepository;

	public List<ProductosModel> listarProductos() {
		return productosRepository.findAll();
	}

	public ProductosModel obtenerProducto(Long id) {
		return productosRepository.findById(id).orElse(null);
	}

	public void guardarProducto(ProductosModel producto) {
		productosRepository.save(producto);
	}

	public void eliminarProducto(Long id) {
		productosRepository.deleteById(id);
	}
	
	public void actualizarProducto(Long id, ProductosModel producto) {
		ProductosModel productoExistente = productosRepository.findById(id).orElse(null);
		if (productoExistente == null) {
			return;
		}
		productoExistente.setNombre_producto(producto.getNombre_producto());
		productoExistente.setDescripcion_producto(producto.getDescripcion_producto());
		productoExistente.setPrecio_producto(producto.getPrecio_producto());
		productoExistente.setStock_producto(producto.getStock_producto());
		productosRepository.save(productoExistente);
	}

}

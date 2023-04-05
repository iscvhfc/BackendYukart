//package com.labanda.yukart.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.labanda.yukart.models.ProductosModel;
//import com.labanda.yukart.repositories.ProductoRepository;
//
//@Service
//public class ProductoService {
//
//	private final ProductoRepository productoRepository;
//
//	@Autowired
//	public ProductoService(ProductoRepository productoRepository) {
//		this.productoRepository = productoRepository;
//	}
//
//	// Create (Metodo para agregar un objeto del tipo Producto y guardarlo en la
//	// base de datos)
//	// Si el producto existe
//	public void crearProducto(ProductosModel producto) {
//		Optional<ProductosModel> productoByName = // variable temporal
//				productoRepository.findByNombre(producto.getNombre_producto());
//		if (productoByName.isPresent()) {
//			throw new IllegalStateException("El producto: " + "[" + producto.getNombre_producto() + "] ya existe");
//		} else {
//			productoRepository.save(producto);
//		}
//	}
//
//	// Read (leer una lista de productos)
//	public List<ProductosModel> leerProductos() {
//		return productoRepository.findAll();
//		// toda la lista de productos
//	}
//
//	// Read (leer un producto con un id especifico)
//	public ProductosModel leerProducto(Long prodId) {
//		return productoRepository.findById(prodId)
//				.orElseThrow(() -> new IllegalStateException("El producto con el Id " + prodId + " no existe"));
//	}
//
//	// Update para actualizar un producto
//	public void actulizarProducto(Long prodId, String nombre_producto, float precio_producto, Integer stock_producto, String descripcion_producto) {
//
//		// Si el producto existe entonces no modifico
//		if (productoRepository.existsById(prodId)) {
//			// entonces lo modifico
//			Producto productoABuscar = productoRepository.getById(prodId); // ya que verifico que mi producto existe, lo
//																			// traigo y lo asigno a una variable llamada
//																			// productoABuscar
//			if (nombre != null)
//				productoABuscar.setNombre(nombre);
//			if (descripcion != null)
//				productoABuscar.setDescripcion(descripcion);
//			if (precio != 0)
//				productoABuscar.setPrecio(precio);
//			if (URL_Imagen != null)
//				productoABuscar.setURL_Imagen(URL_Imagen);
//			// Cuando termino de editar el objeto
//			productoRepository.save(productoABuscar);
//		} else {
//			System.out.println("El porducto con el id" + prodId + "no existe");
//		}
//
//	}
//
//	
//
//	public void actualizarProducto(Long id, Productos producto) {
//		Productos productoExistente = productosRepository.findById(id).orElse(null);
//		if (productoExistente == null) {
//			return;
//		}
//		productoExistente.setNombre(producto.getNombre());
//		productoExistente.setDescripcion(producto.getDescripcion());
//		productoExistente.setPrecio(producto.getPrecio());
//		productosRepository.save(productoExistente);
//	}
//}

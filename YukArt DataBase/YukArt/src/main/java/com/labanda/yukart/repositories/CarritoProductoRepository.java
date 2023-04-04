package com.labanda.yukart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labanda.yukart.models.CarritoProductoModel;

public interface CarritoProductoRepository extends JpaRepository<CarritoProductoModel, Long> {

}

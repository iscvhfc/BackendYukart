package com.labanda.yukart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labanda.yukart.models.ProductosModel;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosModel, Long> {

}

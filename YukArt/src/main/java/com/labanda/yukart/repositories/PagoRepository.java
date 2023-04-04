package com.labanda.yukart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labanda.yukart.models.PagoModel;

@Repository
public interface PagoRepository extends JpaRepository<PagoModel, Long> {
	
}

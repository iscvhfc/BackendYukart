package com.labanda.yukart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labanda.yukart.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}

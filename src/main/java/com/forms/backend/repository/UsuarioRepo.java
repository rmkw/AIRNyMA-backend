package com.forms.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forms.backend.entitys.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
    Usuario findByNombre(String nombre);
}

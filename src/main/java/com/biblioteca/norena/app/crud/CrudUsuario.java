package com.biblioteca.norena.app.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.norena.app.entity.Usuario;

public interface CrudUsuario extends JpaRepository<Usuario, Integer> {
	Usuario findByCorreo(String correo);
}

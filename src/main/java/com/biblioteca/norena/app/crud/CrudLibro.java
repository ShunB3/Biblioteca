package com.biblioteca.norena.app.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.norena.app.entity.Libro;
import com.biblioteca.norena.app.entity.Usuario;

	public interface CrudLibro extends JpaRepository<Libro, Integer> {
		List<Libro> findByUsuario(Usuario usuario);
	}



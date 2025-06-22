package com.herramientas.categoriaservice.dao;

import com.herramientas.categoriaservice.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDao extends JpaRepository<Categoria, Long> {
}

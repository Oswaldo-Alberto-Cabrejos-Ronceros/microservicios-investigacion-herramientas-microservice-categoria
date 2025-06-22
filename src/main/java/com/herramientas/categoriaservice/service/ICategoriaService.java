package com.herramientas.categoriaservice.service;

import com.herramientas.categoriaservice.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> findAllCategorias();
    Categoria getCategoriaById(Long id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Long id,Categoria categoria);
    void deleteCategoria(Long id);
}

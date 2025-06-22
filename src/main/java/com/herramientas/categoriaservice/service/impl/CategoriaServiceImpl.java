package com.herramientas.categoriaservice.service.impl;

import com.herramientas.categoriaservice.dao.ICategoriaDao;
import com.herramientas.categoriaservice.entity.Categoria;
import com.herramientas.categoriaservice.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    private final ICategoriaDao categoriaDao;

    @Autowired
    public CategoriaServiceImpl(ICategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> findAllCategorias() {
        return categoriaDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaDao.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Transactional
    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaDao.save(categoria);
    }

    @Transactional
    @Override
    public Categoria updateCategoria(Long id, Categoria category) {
        Categoria oldCategory = categoriaDao.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        return categoriaDao.save(oldCategory);
    }

    @Transactional
    @Override
    public void deleteCategoria(Long id) {
        categoriaDao.deleteById(id);
    }
}



package com.herramientas.categoriaservice.controller;

import com.herramientas.categoriaservice.entity.Categoria;
import com.herramientas.categoriaservice.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final ICategoriaService categoriaService;

    @Autowired
    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoryById(@PathVariable Long id) {
        Categoria category = categoriaService.getCategoriaById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategories() {
        return ResponseEntity.ok(categoriaService.findAllCategorias());
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategory(@RequestBody Categoria category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.createCategoria(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategory(@PathVariable Long id, @RequestBody Categoria category) {
        return ResponseEntity.ok(categoriaService.updateCategoria(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

}

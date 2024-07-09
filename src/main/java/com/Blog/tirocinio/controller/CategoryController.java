package com.Blog.tirocinio.controller;

import com.Blog.tirocinio.entity.Category;
import com.Blog.tirocinio.entity.Post;
import com.Blog.tirocinio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // lista di tutte le categorie
    @GetMapping("/all")
    public Iterable<Category> getAll() {
        return this.categoryService.findAll();
    }

    // cerca una categoria per id
    @GetMapping("{id}")
    public Category getPostById(@PathVariable("id") long theId) {
        return this.categoryService.findById(theId);
    }

    // crea una nuova categoria passando come parametro solo il nome
    @PostMapping("/create")
    public Category createCategory(Category category) {
        return this.categoryService.saveCategory(category);
    }

    // elimina una categoria per id
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long theId) {
        this.categoryService.deleteById(theId);
    }
}

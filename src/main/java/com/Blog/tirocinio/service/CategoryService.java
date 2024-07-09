package com.Blog.tirocinio.service;

import com.Blog.tirocinio.entity.Category;
import com.Blog.tirocinio.entity.Post;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(long theId);

    Category saveCategory(Category category);

    void deleteById(long theId);

}

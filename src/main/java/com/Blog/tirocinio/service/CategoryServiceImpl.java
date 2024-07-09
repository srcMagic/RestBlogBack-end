package com.Blog.tirocinio.service;

import com.Blog.tirocinio.entity.Category;
import com.Blog.tirocinio.entity.Post;
import com.Blog.tirocinio.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository theCategoryRepository) {
        categoryRepository = theCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long theId) {
        Optional<Category> result = categoryRepository.findById(theId);
        Category cat = null;
        if (result.isPresent()) {
            cat = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return cat;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteById(long theId) {
        categoryRepository.deleteById(theId);

    }
}




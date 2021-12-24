package com.example.coursemc.services;

import com.example.coursemc.domain.Category;
import com.example.coursemc.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {


    private final CategoryRepository repository;

    public CategoryService (CategoryRepository repository) {
        this.repository = repository;
    }

    public Category search (Integer id) {
        return repository.findById(id).orElse(null);
    }


}

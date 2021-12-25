package com.example.coursemc.services;

import com.example.coursemc.domain.Category;
import com.example.coursemc.repositories.CategoryRepository;

import com.example.coursemc.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {


    private final CategoryRepository repository;

    public CategoryService (CategoryRepository repository) {
        this.repository = repository;
    }

    public Category search (Integer id) {
        Optional<Category> category = repository.findById(id);
        return category.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found ID: "+id+", type: "+ Category.class.getName()
        ));
    }


}

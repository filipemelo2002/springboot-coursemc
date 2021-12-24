package com.example.coursemc.resources;

import com.example.coursemc.domain.Category;
import com.example.coursemc.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService service;

    public  CategoryResource(CategoryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/{id}",  method = RequestMethod.GET)
    public ResponseEntity<?> find (@PathVariable("id") Integer id) {
        Category obj = service.search(id);

        return ResponseEntity.ok().body(obj);
    }


}

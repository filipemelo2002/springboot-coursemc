package com.example.coursemc;

import com.example.coursemc.domain.Category;
import com.example.coursemc.domain.Product;
import com.example.coursemc.repositories.CategoryRepository;
import com.example.coursemc.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CoursemcApplication implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    public CoursemcApplication (CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CoursemcApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Informática");
        Category cat2 = new Category(null, "Escritório");

        Product p1 = new Product(null, "Computer", 2000.00);
        Product p2 = new Product(null, "Impressora", 1300.00);
        Product p3 = new Product(null, "Mouse", 80.00);

        cat1.getProducts().addAll(Arrays.asList(p1,p2, p3));
        cat2.getProducts().add(p2);

        p1.getCategories().add(cat1);
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().add(cat1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2,p3));
    }
}

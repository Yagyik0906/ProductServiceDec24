package com.yagyik.productservicedec24.controller;

import com.yagyik.productservicedec24.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") long id) {
        return new Product();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return new ArrayList<Product>();
    }

    @PostMapping("/{product}")
    public Product createProduct(@PathVariable("product") Product product) {
        return new Product();
    }

    @PatchMapping("/{product}")
    public void updateProduct(@PathVariable("product") Product product) {

    }

    @PutMapping("/{product}")
    public void replaceProduct(@PathVariable("product") Product product) {

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id) {

    }
}

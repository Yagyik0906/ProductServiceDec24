package com.yagyik.productservicedec24.controller;

import com.yagyik.productservicedec24.models.Product;
import com.yagyik.productservicedec24.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
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

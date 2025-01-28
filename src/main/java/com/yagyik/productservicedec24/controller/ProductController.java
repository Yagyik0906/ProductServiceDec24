package com.yagyik.productservicedec24.controller;

import com.yagyik.productservicedec24.models.Product;
import com.yagyik.productservicedec24.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId")long productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @PostMapping("")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/all")
    public String saveAllProduct(@RequestBody List<Product> products) {
        productService.saveAllProduct(products);
        return "All products saved";
    }

    @PatchMapping("")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @PutMapping("")
    public Product replaceProduct(@RequestBody Product product) {
        return productService.replaceProduct(product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") long productId) {
        productService.deleteProduct(productId);
        return "Product deleted";
    }
}

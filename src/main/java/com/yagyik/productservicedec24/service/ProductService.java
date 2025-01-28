package com.yagyik.productservicedec24.service;

import com.yagyik.productservicedec24.models.Product;

import java.util.*;

public interface ProductService {
    Product getProduct(Long productId);
    List<Product> getAllProduct();
    String saveAllProduct(List<Product> products);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(Long productId);
    Product replaceProduct(Product product);
}

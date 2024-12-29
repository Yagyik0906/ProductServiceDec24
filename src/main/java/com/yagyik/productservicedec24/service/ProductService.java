package com.yagyik.productservicedec24.service;

import com.yagyik.productservicedec24.models.Product;
import java.util.ArrayList;

public interface ProductService {
    Product getProduct(Long productId);
    ArrayList<Product> getAllProduct();
    Product createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long productId);
    void replaceProduct(Product product);
}

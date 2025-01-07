package com.yagyik.productservicedec24.service;

import com.yagyik.productservicedec24.models.Product;
import com.yagyik.productservicedec24.repositories.ProductRepository;

import java.util.ArrayList;

public class SelfProductService implements ProductService {

    ProductRepository productRepository;

    SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long productId) {

        return null;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public void replaceProduct(Product product) {

    }
}

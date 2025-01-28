package com.yagyik.productservicedec24.service;

import com.yagyik.productservicedec24.models.Category;
import com.yagyik.productservicedec24.models.Product;
import com.yagyik.productservicedec24.repositories.CategoryRepository;
import com.yagyik.productservicedec24.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new RuntimeException("Product not found with id: " + productId);
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public String saveAllProduct(List<Product> products) {
        for(Product product:products){
            checkCategory(product);
            if(!productRepository.existsById(product.getId())){
                throw new RuntimeException("Product not found with id: " + product.getId());
            }
            productRepository.save(product);
        }
        return "All the products are saved successfully";
    }

    @Override
    public Product createProduct(Product product) {
        checkCategory(product);

        return productRepository.save(product);
    }

    private void checkCategory(Product product) {
        Category category= product.getCategory();
        if(category!=null){
            Optional<Category> optionalCategory = categoryRepository.findById(category.getId());
            if(optionalCategory.isPresent()){
                product.setCategory(optionalCategory.get());
            }else{
                Category c=categoryRepository.save(category);
                product.setCategory(c);
            }
        }else{
            throw new RuntimeException("Category should not be empty");
        }
    }

    @Override
    public Product updateProduct(Product product) {
        checkCategory(product);
        if (!productRepository.existsById(product.getId())) {
            throw new RuntimeException("Product not found with id: " + product.getId());
        }

        productRepository.save(product);
        return product;
    }

    @Override
    public String deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found with id: " + productId);
        }
        productRepository.deleteById(productId);
        return "Deleted Product with id: " + productId;
    }

    @Override
    public Product replaceProduct(Product product) {
        if (!productRepository.existsById(product.getId())) {
            throw new RuntimeException("Product not found with id: " + product.getId());
        }
        productRepository.save(product);
        return product;
    }
}

package com.yagyik.productservicedec24.repositories;

import com.yagyik.productservicedec24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find a product by its ID
    Optional<Product> findById(Long productId);

    // Fetch all products
    List<Product> findAll();

    // Create or update a product
   Product save(Product product);

    // Delete a product by its ID
    void deleteById(Long productId);

    // Delete all products
    void deleteAll();

    // Check if a product exists by its ID
    boolean existsById(Long productId);
}

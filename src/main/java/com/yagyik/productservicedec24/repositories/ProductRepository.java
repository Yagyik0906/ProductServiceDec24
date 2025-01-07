package com.yagyik.productservicedec24.repositories;

import com.yagyik.productservicedec24.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();
}

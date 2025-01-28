package com.yagyik.productservicedec24.repositories;

import com.yagyik.productservicedec24.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long categoryId);

    @Override
    List<Category> findAll();

   Category save(Category entity);
}

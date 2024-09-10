package com.main.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.main.entities.Product;

@Repository
public interface Productrepo extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(Long categoryId);
	Optional<Product> findById(Long productId);
}

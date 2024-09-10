package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entities.Category;
@Repository
public interface CategoriesRepo extends JpaRepository<Category, Long> {

}

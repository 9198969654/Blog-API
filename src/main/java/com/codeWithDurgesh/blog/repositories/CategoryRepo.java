package com.codeWithDurgesh.blog.repositories;

import com.codeWithDurgesh.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}

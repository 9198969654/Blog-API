package com.codeWithDurgesh.blog.repositories;

import com.codeWithDurgesh.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}

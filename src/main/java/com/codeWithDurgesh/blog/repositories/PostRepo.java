package com.codeWithDurgesh.blog.repositories;

import com.codeWithDurgesh.blog.entities.Category;
import com.codeWithDurgesh.blog.entities.Post;
import com.codeWithDurgesh.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);
}

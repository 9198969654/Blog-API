package com.codeWithDurgesh.blog.services;

import com.codeWithDurgesh.blog.entities.Post;
import com.codeWithDurgesh.blog.payloads.PostDto;
import com.codeWithDurgesh.blog.payloads.PostResponse;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get All Post
   PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //get Single Post
    PostDto getPostById(Integer postId);

    //get All post by Category
    List<PostDto> getPostsByCategory(Integer categoryId);

    //get All Post by User
    List<PostDto> getPostsByUser(Integer userId);

    //search post
    List<PostDto> searchPosts(String keyword);

}

package com.codeWithDurgesh.blog.services.impl;

import com.codeWithDurgesh.blog.entities.Category;
import com.codeWithDurgesh.blog.entities.Post;
import com.codeWithDurgesh.blog.entities.User;
import com.codeWithDurgesh.blog.exceptions.ResourceNotFoundException;
import com.codeWithDurgesh.blog.payloads.PostDto;
import com.codeWithDurgesh.blog.repositories.CategoryRepo;
import com.codeWithDurgesh.blog.repositories.PostRepo;
import com.codeWithDurgesh.blog.repositories.UserRepo;
import com.codeWithDurgesh.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;





    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException("User", "User id", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category", "Category id", categoryId));



        Post post =  this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost =  this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post", "post Id", postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = this.postRepo.save(post);
        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post", "post Id", postId));
        this.postRepo.delete(post);

    }

    @Override
    public List<PostDto> getAllPost() {
       List<Post> allPost =  this.postRepo.findAll();
      List<PostDto> postDtos =  allPost.stream().map((post)
               -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
       Post post =  this.postRepo.findById(postId).orElseThrow(()
                -> new ResourceNotFoundException("Post", "post Id" , postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()
                -> new ResourceNotFoundException("Category", "catogory Id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);

        List<PostDto> postDtos = posts.stream().map((post)
                -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {

        User user = this.userRepo.findById(userId).orElseThrow(()
                -> new ResourceNotFoundException("User", "userId", userId));

       List<Post> posts =  this.postRepo.findByUser(user);

       List<PostDto> postDtos  = posts.stream().map((post)
               -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}

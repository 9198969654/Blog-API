package com.codeWithDurgesh.blog.services;

import com.codeWithDurgesh.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
     CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete
     void deleteCategory(Integer categoryId);

    //get by id
     CategoryDto getCategory(Integer categoryId);

    //get All
    List<CategoryDto> getCategories();
}

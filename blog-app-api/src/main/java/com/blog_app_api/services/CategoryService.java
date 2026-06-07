package com.blog_app_api.services;

import com.blog_app_api.payload.CategoryDTO;

import java.net.InterfaceAddress;
import java.util.List;

public interface CategoryService {

//    getall
     List<CategoryDTO> getAllCategory();

//    getone
   CategoryDTO getCategoryById(Integer categoryId);


//    create
    CategoryDTO createCategory(CategoryDTO categoryDto);

//    update
    CategoryDTO modifyCategoryData(CategoryDTO categoryDto ,Integer categoryId);


//    delete
    void deleteCategory( Integer categoryId);



}

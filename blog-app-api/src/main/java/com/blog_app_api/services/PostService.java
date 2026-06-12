package com.blog_app_api.services;

import com.blog_app_api.entity.Post;
import com.blog_app_api.payload.PostDTO;

import java.util.List;

public interface PostService {

    //create Service
    PostDTO createPost (PostDTO postDTO, Integer userId, Integer categoryId);

    // update Service
    PostDTO updatePost(PostDTO postDTO, Integer PostId);


    //delete Srvice
    void deletePost(Integer postId);

    //getAllPost Service
    List<Post> getAllPost();

    //getPostById
    PostDTO
    getPostById(Integer postId);

    //getAll post By Category Serrvice
    List<Post> getPostByCategory(Integer categoryId);


    // get all post By UserId
    List<Post> getPostByuserId(Integer userId);


    //getpostBySearch
    List<Post> SearchPost(String keyWord);


}

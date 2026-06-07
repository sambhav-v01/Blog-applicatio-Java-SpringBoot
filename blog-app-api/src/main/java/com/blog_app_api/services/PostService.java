package com.blog_app_api.services;

import com.blog_app_api.entity.Post;
import com.blog_app_api.payload.PostDTO;

import java.util.List;

public interface PostService {

    //create Service
    Post createPost (PostDTO postDTO);

    // update Service
    Post updatePost(PostDTO postDTO, Integer PostId);


    //delete Srvice
    void deletePost(Integer postId);

    //getAllPost Service
    List<Post> getAllPost();

    //getPostById
    Post getPostById(Integer postId);

    //getAll post By Category Serrvice
    List<Post> getPostByCategory(Integer categoryId);


    // get all post By UserId
    List<Post> getPostByuserId(Integer userId);


    //getpostBySearch
    List<Pos>


}

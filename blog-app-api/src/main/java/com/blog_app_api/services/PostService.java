package com.blog_app_api.services;

import com.blog_app_api.entity.Post;
import com.blog_app_api.payload.PostDTO;
import com.blog_app_api.payload.PostPaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {

    //create Service
    PostDTO createPost (PostDTO postDTO, Integer userId, Integer categoryId);

    // update Service
    PostDTO updatePost(PostDTO postDTO, Integer PostId);


    //delete Srvice
    void deletePost(Integer postId);

    //getAllPost Service using pagnation with custom Method
    PostPaginationResponse getAllPost(Integer pageNumber , Integer pageSize);


   //getAllPost using pagination by use PageInterface
    //Page<PostDTO> getAllPost(Pageable pageable);


    //getPostById
    PostDTO
    getPostById(Integer postId);

    //getAll post By Category Serrvice
    List<PostDTO> getPostByCategory(Integer categoryId);


    // get all post By UserId
    List<PostDTO> getPostByuser(Integer userId);


    //getpostBySearch
    List<PostDTO> SearchPost(String keyWord);


}

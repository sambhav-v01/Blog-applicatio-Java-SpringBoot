package com.blog_app_api.controller;

import com.blog_app_api.entity.Category;
import com.blog_app_api.entity.User;
import com.blog_app_api.payload.PostDTO;
import com.blog_app_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId,@PathVariable Integer categoryId){
      PostDTO createdPostDTO= postService.createPost(postDTO,userId,categoryId);
       return new ResponseEntity<PostDTO>(createdPostDTO, HttpStatus.CREATED);
    }

}

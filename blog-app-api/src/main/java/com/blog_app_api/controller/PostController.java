package com.blog_app_api.controller;

import com.blog_app_api.entity.Category;
import com.blog_app_api.entity.User;
import com.blog_app_api.payload.PostDTO;
import com.blog_app_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    PostService postService;

    // creating a post
    @PostMapping("/users/{userId}/categories/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId,@PathVariable Integer categoryId){
      PostDTO createdPostDTO= postService.createPost(postDTO,userId,categoryId);
       return new ResponseEntity<PostDTO>(createdPostDTO, HttpStatus.CREATED);
    }

    //get all post of a User
    @GetMapping("/users/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getAllPostOfUser(@PathVariable Integer userId){
       List<PostDTO> listOfpots= postService.getPostByuser(userId);
       return new ResponseEntity<List<PostDTO>>(listOfpots, HttpStatus.OK);
    }

    //    // get all post of a category
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getAllPostOfCategory( @PathVariable Integer categoryId){
        List<PostDTO> listOfpots= postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDTO>>(listOfpots, HttpStatus.OK);
    }

    //get all post
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPost(){
       List<PostDTO> allPost= postService.getAllPost();
      return new ResponseEntity<List<PostDTO>>(allPost, HttpStatus.OK);
    }



    //get post by postId
    @GetMapping("posts/{postId}")
    public  ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId){
        PostDTO post= postService.getPostById(postId);
        return new ResponseEntity<PostDTO>(post, HttpStatus.OK);
    }


    //postDelete
    @DeleteMapping("posts/{postId}")
    public  ResponseEntity<?> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("posts/{postId}")
    public ResponseEntity<PostDTO> updatedPost(@RequestBody PostDTO postDTO ,@PathVariable Integer postId){
       PostDTO postDto= postService.updatePost(postDTO, postId);
       return new ResponseEntity<PostDTO>(postDto,HttpStatus.OK);
    }










}

package com.blog_app_api.service.impl.UserServiceImpl;

import com.blog_app_api.Repository.CategoryRepository;
import com.blog_app_api.Repository.PostRepository;
import com.blog_app_api.Repository.UserRepository;
import com.blog_app_api.entity.Category;
import com.blog_app_api.entity.Post;
import com.blog_app_api.entity.User;
import com.blog_app_api.exceptions.ResourceNotFoundException;
import com.blog_app_api.payload.PostDTO;
import com.blog_app_api.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {

   @Autowired
   private PostRepository postRepository;

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private CategoryRepository categoryRepository;
    @Autowired
   private ModelMapper modelMapper;

    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId ) {

       Category category= categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","Id",categoryId));
        User user=userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        Post post=postDtoToPost(postDTO);
        post.setAddDate(new Date());
        post.setUser(user);
        post.setCategory(category);
       Post createdpost= postRepository.save(post);
       return postToPostDTO(createdpost);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer PostId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return List.of();
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostByuserId(Integer userId) {
        return List.of();
    }


    public List<Post> SearchPost(String keyword) {
        return List.of();
    }


    private Post postDtoToPost(PostDTO postDTO){
       Post post= modelMapper.map(postDTO, Post.class);
       return post;
    }

    private PostDTO postToPostDTO(Post post){
        PostDTO postDTO= modelMapper.map(post, PostDTO.class);
        return postDTO;
    }


}

package com.blog_app_api.service.impl.UserServiceImpl;

import com.blog_app_api.Repository.PostRepository;
import com.blog_app_api.entity.Post;
import com.blog_app_api.payload.PostDTO;
import com.blog_app_api.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

   @Autowired
   private PostRepository postRepository;
    @Autowired
   private ModelMapper modelMapper;

    @Override
    public Post createPost(PostDTO postDTO) {
        return null;
    }

    @Override
    public Post updatePost(PostDTO postDTO, Integer PostId) {
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
    public Post getPostById(Integer postId) {
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

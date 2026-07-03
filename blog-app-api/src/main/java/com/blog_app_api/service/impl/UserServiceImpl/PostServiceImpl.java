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
import java.util.stream.Collectors;

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
       Post post= postRepository.findById(PostId).orElseThrow(()->new ResourceNotFoundException("post","Id",PostId));
       post.setPostTitle(postDTO.getPostTitle());
       post.setPostDescription(postDTO.getPostDescription());
       Post post1 = postRepository.save(post);

      return  postToPostDTO(post1);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post= postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("postId", "Id", postId));
         postRepository.delete(post);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> allpostList= postRepository.findAll();
        List<PostDTO> allpostDtoList=allpostList.stream().map(post->postToPostDTO(post)).collect(Collectors.toList());
        return allpostDtoList;
    }

    @Override
    public PostDTO getPostById(Integer postId) {
        Post post=postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","Id",postId));
        return postToPostDTO(post);
    }

    @Override
    public List<PostDTO> getPostByCategory(Integer categoryId) {
        Category category =categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "ID", categoryId));
            List<Post> post=postRepository.findByCategory(category);
            List<PostDTO> listOfPostofCategory= post.stream().map(p-> postToPostDTO(p)).collect(Collectors.toList());
        return listOfPostofCategory;
    }

    @Override
    public List<PostDTO> getPostByuser(Integer userId) {
        User user= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","ID",userId));
           List<Post> posts= postRepository.findByUser(user);
         List<PostDTO> listOFPostOfUser=  posts.stream().map(p->postToPostDTO(p)).collect(Collectors.toList());
        return listOFPostOfUser;
    }


    public List<PostDTO> SearchPost(String keyword) {
        return List.of();
    }










//change method postDTO to POST
    private Post postDtoToPost(PostDTO postDTO){
       Post post= modelMapper.map(postDTO, Post.class);
       return post;
    }

    // change post to POSTDTO
    private PostDTO postToPostDTO(Post post){
        PostDTO postDTO= modelMapper.map(post, PostDTO.class);
        return postDTO;
    }


}

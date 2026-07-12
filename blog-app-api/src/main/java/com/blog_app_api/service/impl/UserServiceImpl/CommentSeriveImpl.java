package com.blog_app_api.service.impl.UserServiceImpl;

import com.blog_app_api.Repository.CommentRepository;
import com.blog_app_api.Repository.PostRepository;
import com.blog_app_api.Repository.UserRepository;
import com.blog_app_api.entity.Comment;
import com.blog_app_api.entity.Post;
import com.blog_app_api.entity.User;
import com.blog_app_api.exceptions.ResourceNotFoundException;
import com.blog_app_api.payload.CommentDTO;
import com.blog_app_api.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class CommentSeriveImpl implements CommentService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    CommentSeriveImpl(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository, ModelMapper modelMapper){
        this.postRepository=postRepository;
        this.userRepository=userRepository;
        this.commentRepository=commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Integer postId, Integer userId) {
       Post post= postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId", postId));
       User user =userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
       Comment comment =CommentDTOToComment(commentDTO);
       comment.setPost(post);
       comment.setUser(user);
        Comment comments=commentRepository.save(comment);
        return commentToCommentDTO(comments);
    }

    @Override
    public Void deleteComment(Integer commentId) {
       Comment comment =commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("commnt","CommentId",commentId));
       commentRepository.delete(comment);
       return null;
    }

    @Override
    public List<CommentDTO> getCommentByPost(Integer postId) {
       Post post= postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId",postId));
      List<Comment> comments= commentRepository.findByPostAndParentCommentIsNull(post);
      List<CommentDTO>commentDTOS= comments.stream().map(this::commentToCommentDTO).collect(Collectors.toList());
      return commentDTOS;
    }

    @Override
    public CommentDTO updateComment(CommentDTO commentDTO, Integer commentID) {
     Comment comment = commentRepository.findById(commentID).orElseThrow(()-> new ResourceNotFoundException("Commnt","CommentId", commentID));
     comment.setContent(commentDTO.getContent());
     Comment updateComment= commentRepository.save(comment);
     return commentToCommentDTO(updateComment);
    }

    @Override
    public CommentDTO replyComment(CommentDTO commentDTO, Integer parentCommentId, Integer userId){
      Comment comment  =commentRepository.findById(parentCommentId).orElseThrow(()-> new ResourceNotFoundException("Comment","commentID",parentCommentId));
      User user=  userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId",userId));
     Comment reply= CommentDTOToComment(commentDTO);
     reply.setUser(user);
     reply.setParentComment(comment);
     reply.setPost(comment.getPost());
     Comment savedReply= commentRepository.save(reply);

        return commentToCommentDTO(savedReply);
    }




    private CommentDTO commentToCommentDTO(Comment comment){

        CommentDTO dto = modelMapper.map(comment, CommentDTO.class);

        dto.setUserId(comment.getUser().getId());
        dto.setUserName(comment.getUser().getUserName());

        List<CommentDTO> replies = comment.getReplies()
                .stream()
                .map(this::commentToCommentDTO)
                .collect(Collectors.toList());

        dto.setResplies(replies);

        return dto;
    }

    private Comment CommentDTOToComment(CommentDTO commentDTO){
       Comment comment = modelMapper.map(commentDTO, Comment.class);
       return comment;
    }



}

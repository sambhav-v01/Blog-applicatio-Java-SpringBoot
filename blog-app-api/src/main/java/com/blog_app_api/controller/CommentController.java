package com.blog_app_api.controller;

import com.blog_app_api.payload.CommentDTO;
import com.blog_app_api.services.CommentService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CommentController {

     private final CommentService commentService;
    CommentController(CommentService commentService){
      this.commentService=commentService;
    }

    @PostMapping("posts/{postId}/user/{userId}/comments")
    public ResponseEntity<CommentDTO> addComment (@Valid @RequestBody CommentDTO commentDTO, @PathVariable Integer postId, @PathVariable Integer userId){
       CommentDTO addedComment = commentService.createComment(commentDTO,postId,userId);
          return new ResponseEntity<CommentDTO>(addedComment, HttpStatus.CREATED);
    }
    @PostMapping("comments/{commentId}/users/{userId}")
    public ResponseEntity<CommentDTO> replyComment(@RequestBody CommentDTO commentDTO, @PathVariable Integer commentId, @PathVariable Integer userId){

       CommentDTO comment = commentService.replyComment(commentDTO ,commentId ,userId);
       return new ResponseEntity<CommentDTO>(comment,HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments")
    public ResponseEntity<List<CommentDTO>> getPostComment(@PathVariable Integer postId){
       List<CommentDTO> postComments= commentService.getCommentByPost(postId);
        return new ResponseEntity<List<CommentDTO>>(postComments,HttpStatus.OK);
    }

    @DeleteMapping("comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(Map.of("message","User deleted Successfuly"), HttpStatus.OK);
    }

    @PutMapping("commnts/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO, @PathVariable Integer commentId){
       CommentDTO updatedComment = commentService.updateComment(commentDTO,commentId);
       return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }


}

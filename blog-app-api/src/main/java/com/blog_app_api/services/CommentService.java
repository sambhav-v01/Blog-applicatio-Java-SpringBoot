package com.blog_app_api.services;

import com.blog_app_api.entity.Comment;
import com.blog_app_api.payload.CommentDTO;

import java.util.List;

public interface CommentService  {

    CommentDTO createComment(CommentDTO commentDTO,
                             Integer postId,
                             Integer userId);


    Void deleteComment(Integer commentId);

    List<CommentDTO> getCommentByPost(Integer postId);

    CommentDTO updateComment(CommentDTO commentDTO, Integer commentID);

    //replay to comment

    CommentDTO replyComment(CommentDTO commentDTO, Integer parentCommentID, Integer userId);




}

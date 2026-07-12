package com.blog_app_api.Repository;

import com.blog_app_api.entity.Comment;
import com.blog_app_api.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostAndParentCommentIsNull(Post post);
}

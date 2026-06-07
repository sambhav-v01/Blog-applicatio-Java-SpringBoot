package com.blog_app_api.Repository;

import com.blog_app_api.entity.Category;
import com.blog_app_api.entity.Post;
import com.blog_app_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}

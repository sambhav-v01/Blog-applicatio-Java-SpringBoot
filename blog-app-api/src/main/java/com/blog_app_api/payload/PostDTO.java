package com.blog_app_api.payload;

import com.blog_app_api.entity.Category;
import com.blog_app_api.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PostDTO {

    private String postTitle;

    private String postDescription;

    //   private String imageName;
    private Date addDate;

    private CategoryDTO category;

    private UserDTO user;
}

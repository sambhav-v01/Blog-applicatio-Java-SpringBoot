package com.blog_app_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer postId;

   private String postTitle;

   private String postDescription;

   private String imageName;

   private Date addDate;

   @ManyToOne
    private Category category;

   @ManyToOne
   private User user;








}

package com.blog_app_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

//   private String imageName;
   private Date addDate;

   @ManyToOne
    private Category category;

   @ManyToOne
   private User user;


   @OneToMany(mappedBy ="post", cascade = CascadeType.ALL)
   private Set<Comment> comments= new HashSet<>();








}

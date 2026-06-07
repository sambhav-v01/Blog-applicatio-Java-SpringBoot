package com.blog_app_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String userName;

    private String email;

    private String password;

    private String about;


   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> Posts= new ArrayList<>();


}

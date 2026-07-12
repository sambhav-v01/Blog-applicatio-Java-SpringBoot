package com.blog_app_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer commentId;

    @Column(nullable = false)
    private  String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch= FetchType.LAZY)
    private User user;

    // Parent comment (null for top-level comments)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    // Replies to this comment
    @OneToMany(mappedBy = "parentComment",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Comment> replies = new ArrayList<>();
}

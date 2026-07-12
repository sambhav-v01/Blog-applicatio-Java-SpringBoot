    package com.blog_app_api.payload;

    import com.blog_app_api.entity.Category;
    import com.blog_app_api.entity.Comment;
    import com.blog_app_api.entity.User;
    import jakarta.persistence.ManyToOne;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.Size;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.Date;
    import java.util.HashSet;
    import java.util.Set;

    @NoArgsConstructor
    @Getter
    @Setter
    @AllArgsConstructor
    public class PostDTO {

        private Integer postId;

        @NotBlank(message = "Post title is required")
        @Size(min = 5, max = 100)
        private String postTitle;

        @NotBlank(message = "Post description is required")
        @Size(min = 20, max = 5000)
        private String postDescription;;

        //   private String imageName;
        private Date addDate;

        private CategoryDTO category;

        private UserDTO user;
    }

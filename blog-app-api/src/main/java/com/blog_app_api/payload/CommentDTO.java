package com.blog_app_api.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Integer commentId;
    @NotBlank(message = "Can not be a null")
    private String content;
    private Integer userId;
    private String userName;

    private List<CommentDTO> resplies=new ArrayList<>();

}

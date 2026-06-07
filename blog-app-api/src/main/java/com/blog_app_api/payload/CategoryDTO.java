package com.blog_app_api.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CategoryDTO {

    private Integer categoryId;


    @NotBlank(message = "Title can not be empty")
    @Size(min=4, message = "Title shoulb be atleast 4 Char")
    private String categoryTitle;

    @NotBlank
    @Size(message = "Description can not be empty")
    private String categoryDescription;

}

package com.blog_app_api.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PostPaginationResponse {
    private List<PostDTO> content;
    private int pageNumber;
    private  int pageSize;
    private long totalElement;
    private int totalPages;
    private boolean lastPage;
}

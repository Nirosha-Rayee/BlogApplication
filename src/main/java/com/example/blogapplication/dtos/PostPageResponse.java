package com.example.blogapplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPageResponse {
    private List<PostDto> content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private Long totalElements;
    private boolean last;
}

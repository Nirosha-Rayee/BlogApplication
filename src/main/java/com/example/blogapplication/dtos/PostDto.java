package com.example.blogapplication.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PostDto {
    private Long id;
    private String title;
    private String description;
    private String content;


}

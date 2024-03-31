package com.example.blogapplication.service;

import com.example.blogapplication.dtos.PostDto;
import com.example.blogapplication.dtos.PostPageResponse;

import java.util.List;

public interface PostServiceInterface {
    PostDto createPost(PostDto postDto);

//   List<PostDto> getAllPosts();
    PostPageResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(Long id);

    PostDto updatePost(PostDto postDto, Long id);

    void deletePost(Long id);

}

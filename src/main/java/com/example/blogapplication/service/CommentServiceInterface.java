package com.example.blogapplication.service;

import com.example.blogapplication.dtos.CommentDto;

import java.util.List;

public interface CommentServiceInterface {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);

    void deleteComment(Long postId, Long commentId);


}

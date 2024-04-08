package com.example.blogapplication.repositories;

import com.example.blogapplication.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment save(Comment comment);

    List<Comment> findByPostId(long postId);


}

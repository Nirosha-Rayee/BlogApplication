package com.example.blogapplication.repositories;

import com.example.blogapplication.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post save(Post post);

    List<Post> findAll();

}

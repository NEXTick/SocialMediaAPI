package com.example.socialmediaapi.repositories;

import com.example.socialmediaapi.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}

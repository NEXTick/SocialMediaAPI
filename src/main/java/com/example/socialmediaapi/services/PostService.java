package com.example.socialmediaapi.services;


import com.example.socialmediaapi.models.Post;
import com.example.socialmediaapi.models.User;
import com.example.socialmediaapi.repositories.PostRepository;
import com.example.socialmediaapi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void save(Post post, User user) {
        post.setCreater(user);
        postRepository.save(post);
    }

    public void update(int id, Post post) {
        Post postToBeUpdated = postRepository.findById(id).get();

        post.setId(id);
        post.setCreater(postToBeUpdated.getCreater());
        postRepository.save(post);
    }

    public void delete(int id) {
        postRepository.deleteById(id);
    }


}

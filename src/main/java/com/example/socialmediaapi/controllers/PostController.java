package com.example.socialmediaapi.controllers;


import com.example.socialmediaapi.models.Post;
import com.example.socialmediaapi.services.PostService;
import com.example.socialmediaapi.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("{userId}/posts")
public class PostController {

    private final PostService postService;

    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping()
    List<Post> findAll() {
        return postService.findAll()
    }

    @PostMapping()
    public String
}

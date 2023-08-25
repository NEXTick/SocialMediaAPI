package com.example.socialmediaapi.controllers;


import com.example.socialmediaapi.models.Post;
import com.example.socialmediaapi.models.User;
import com.example.socialmediaapi.services.PostService;
import com.example.socialmediaapi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService postService;

    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping()
    public String create(@ModelAttribute("post") @Valid Post post, @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ""; //TO DO
        }
        postService.save(post, user);
        return ""; //TO DO
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("post") @Valid Post post,BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return ""; //TO DO
        }
        postService.update(id, post);
        return ""; //TO DO
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        postService.delete(id);
        return ""; //TO DO
    }

}

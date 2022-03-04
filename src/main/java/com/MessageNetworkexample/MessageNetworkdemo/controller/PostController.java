package com.MessageNetworkexample.MessageNetworkdemo.controller;

import com.MessageNetworkexample.MessageNetworkdemo.model.Post;
import com.MessageNetworkexample.MessageNetworkdemo.requests.PostCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.requests.PostUpdateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.response.PostResponse;
import com.MessageNetworkexample.MessageNetworkdemo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostResponse> getAllPost(@RequestParam Optional<Long> userId) {
        return postService.getAllPost(userId);

    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Long id) {
        return postService.findPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody PostCreateRequest postCreateRequest) {
        return postService.createPost(postCreateRequest);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest postUpdateRequest) {
        return postService.updatePost(id, postUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        postService.deletePostById(id);
    }
}

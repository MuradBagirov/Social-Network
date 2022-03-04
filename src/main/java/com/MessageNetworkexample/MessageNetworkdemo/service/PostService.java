package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.Post;
import com.MessageNetworkexample.MessageNetworkdemo.requests.PostCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.requests.PostUpdateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.response.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostResponse>getAllPost(Optional<Long> userId);
    Post findPostById(Long id);
    Post createPost(PostCreateRequest postCreateRequest);
    Post updatePost(Long id, PostUpdateRequest postUpdateRequest);
    void deletePostById(Long id);

}

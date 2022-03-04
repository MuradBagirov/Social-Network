package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.Comment;
import com.MessageNetworkexample.MessageNetworkdemo.requests.CommentCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.requests.CommentUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> getAllComment(Optional<Long>userId,Optional<Long>postId);

    Comment commentById(Long id);

    Comment createComment(CommentCreateRequest commentCreateRequest);

    Comment updateComment(Long id,CommentUpdateRequest commentUpdateRequest);

    void deleteById(Long id);

}

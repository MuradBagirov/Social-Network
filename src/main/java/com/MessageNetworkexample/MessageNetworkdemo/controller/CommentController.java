package com.MessageNetworkexample.MessageNetworkdemo.controller;

import com.MessageNetworkexample.MessageNetworkdemo.model.Comment;
import com.MessageNetworkexample.MessageNetworkdemo.requests.CommentCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.requests.CommentUpdateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public List<Comment> getAllComment(@RequestParam Optional<Long>userId,
                                                       @RequestParam Optional<Long> postId) {

        return commentService.getAllComment(userId,postId);

    }

    @GetMapping("/{id}")
    public Comment findById(@PathVariable Long id) {
        return commentService.commentById(id);
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest){
        return commentService.createComment(commentCreateRequest);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id,@RequestBody CommentUpdateRequest commentUpdateRequest){
        return commentService.updateComment(id,commentUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        commentService.deleteById(id);
    }
}

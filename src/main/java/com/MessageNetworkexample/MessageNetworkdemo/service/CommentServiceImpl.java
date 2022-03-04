package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.Comment;
import com.MessageNetworkexample.MessageNetworkdemo.model.Post;
import com.MessageNetworkexample.MessageNetworkdemo.model.User;
import com.MessageNetworkexample.MessageNetworkdemo.repository.CommentRepository;
import com.MessageNetworkexample.MessageNetworkdemo.requests.CommentCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.requests.CommentUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    private final UserService userService;

    private final PostService postService;

    @Override
    public List<Comment> getAllComment(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return commentRepository.findByUserId(userId.get());
        } else if (postId.isPresent()) {
            return commentRepository.findByPostId(postId.get());
        } else return commentRepository.findAll();
    }


    @Override
    public Comment commentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    @Override
    public Comment createComment(CommentCreateRequest commentCreateRequest) {
        User userById = userService.getUserById(commentCreateRequest.getId());
        Post postById = postService.findPostById(commentCreateRequest.getId());
        if (userById == null && postById == null) {
            throw new RuntimeException("File not found");
        }
        Comment comment = new Comment();
        comment.setId(commentCreateRequest.getId());
        comment.setPost(postById);
        comment.setUser(userById);
        comment.setText(commentCreateRequest.getText());
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Long id, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> byId = commentRepository.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();
            comment.setText(commentUpdateRequest.getText());
            return commentRepository.save(comment);
        } else return null;
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}

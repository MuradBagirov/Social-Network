package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.Post;
import com.MessageNetworkexample.MessageNetworkdemo.model.User;
import com.MessageNetworkexample.MessageNetworkdemo.repository.PostRepository;
import com.MessageNetworkexample.MessageNetworkdemo.requests.PostCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.requests.PostUpdateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public List<PostResponse> getAllPost(Optional<Long> userId) {
        List<Post> list;
        if (userId.isPresent()) {
            list = postRepository.findByUserId(userId.get());
        } else list = postRepository.findAll();

        return list.stream().map(post -> new PostResponse(post))
                .collect(Collectors.toList());

    }

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    @Override
    public Post createPost(PostCreateRequest postCreateRequest) {
        User userById = userService.getUserById(postCreateRequest.getId());
        if (userById.getId() == 0 || userById.getId() == null) {
            throw new RuntimeException("File not found");
        }
        Post post = new Post();
        post.setId(postCreateRequest.getId());
        post.setText(postCreateRequest.getText());
        post.setTitle(postCreateRequest.getTitle());
        post.setUser(userById);
        return postRepository.save(post);
    }


    @Override
    public Post updatePost(Long id, PostUpdateRequest postUpdateRequest) {
        Optional<Post> byId = postRepository.findById(id);
        if (byId.isPresent()) {
            Post post1 = new Post();
            post1.setText(postUpdateRequest.getText());
            post1.setTitle(postUpdateRequest.getTitle());
            postRepository.save(post1);
            return post1;
        } else return null;
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);

    }
}

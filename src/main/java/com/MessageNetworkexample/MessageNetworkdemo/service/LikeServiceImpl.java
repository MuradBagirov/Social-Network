package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.Like;
import com.MessageNetworkexample.MessageNetworkdemo.model.Post;
import com.MessageNetworkexample.MessageNetworkdemo.model.User;
import com.MessageNetworkexample.MessageNetworkdemo.repository.LikeRepository;
import com.MessageNetworkexample.MessageNetworkdemo.requests.LikeCreateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;


    @Override
    public List<Like> getAllLike(Optional<Long> userId, Optional<Long> postId) {
        if (userId.isPresent() && postId.isPresent()) {
            return likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
        } else if (userId.isPresent()) {
            return likeRepository.findByUserId(userId.get());
        } else if (postId.isPresent())
            return likeRepository.findByPostId(postId.get());
        else return likeRepository.findAll();

    }

    public Like likeById(Long id) {
        return likeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found"));
    }

    @Override
    public Like createLike(LikeCreateRequest likeCreateRequest) {
        User userById = userService.getUserById(likeCreateRequest.getId());
        Post postById = postService.findPostById(likeCreateRequest.getId());
        if (userById.getId() == 0 || userById.getId() == null) {
            throw new RuntimeException("File not found");
        }
        Like like = new Like();
        like.setId(likeCreateRequest.getId());
        like.setPost(postById);
        like.setUser(userById);
        return likeRepository.save(like);
    }

    @Override
    public Like updateLike(Long id, Like like) {
        Optional<Like> byId = likeRepository.findById(id);
        if (byId.isPresent()){
            Like like1 = byId.get();
           return likeRepository.save(like1);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        likeRepository.deleteById(id);
    }
}

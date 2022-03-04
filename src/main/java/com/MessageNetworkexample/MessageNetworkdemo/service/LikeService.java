package com.MessageNetworkexample.MessageNetworkdemo.service;

import com.MessageNetworkexample.MessageNetworkdemo.model.Like;
import com.MessageNetworkexample.MessageNetworkdemo.requests.LikeCreateRequest;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    List<Like> getAllLike(Optional<Long>userId, Optional<Long>postId);
    Like likeById(Long id);
    Like createLike(LikeCreateRequest likeCreateRequest);
    Like updateLike(Long id,Like like);
    void deleteById(Long id);



}

package com.MessageNetworkexample.MessageNetworkdemo.controller;

import com.MessageNetworkexample.MessageNetworkdemo.model.Like;
import com.MessageNetworkexample.MessageNetworkdemo.requests.LikeCreateRequest;
import com.MessageNetworkexample.MessageNetworkdemo.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;


    @GetMapping
    public List<Like> getAllLike(@RequestParam Optional<Long> userId,
                                 @RequestParam Optional<Long>postId) {
        return likeService.getAllLike(userId, postId);
    }

    @GetMapping("/{id}")
    public Like likeById(@PathVariable Long id) {
        return likeService.likeById(id);
    }

    @PostMapping
    public Like createLike(@RequestBody LikeCreateRequest likeCreateRequest) {
        return likeService.createLike(likeCreateRequest);
    }

    @PutMapping
    public Like updateLike(@PathVariable Long id,@RequestBody Like like) {
        return likeService.updateLike(id,like);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        likeService.deleteById(id);
    }

}

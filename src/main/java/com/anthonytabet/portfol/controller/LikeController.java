package com.anthonytabet.portfol.controller;

import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.model.User;
import com.anthonytabet.portfol.service.LikeService;
import com.anthonytabet.portfol.service.PostService;
import com.anthonytabet.portfol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @PostMapping("/posts/{postId}/likes")
    public ResponseEntity<?> likePost(@PathVariable Long postId, @RequestBody Long userId) {
        Post post = postService.findById(postId);
        User user = userService.findById(userId);
        likeService.likePost(user, post);
        int likesCount = likeService.countLikesByPost(post);  // Fetch the new likes count
        return ResponseEntity.ok(likesCount);
    }

    @DeleteMapping("/posts/{postId}/likes")
    public ResponseEntity<?> unlikePost(@PathVariable Long postId, @RequestBody Long userId) {
        Post post = postService.findById(postId);
        User user = userService.findById(userId);
        likeService.unlikePost(user, post);
        int likesCount = likeService.countLikesByPost(post);  // Fetch the new likes count
        return ResponseEntity.ok(likesCount);
    }
}

package com.anthonytabet.portfol.service;

import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.model.User;
import org.springframework.stereotype.Service;

public interface LikeService {
    void likePost(User user, Post post);
    void unlikePost(User user, Post post);

    int countLikesByPost(Post post);
}
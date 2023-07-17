package com.anthonytabet.portfol.service.impl;

import com.anthonytabet.portfol.model.Like;
import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.model.User;
import com.anthonytabet.portfol.repository.LikeRepository;
import com.anthonytabet.portfol.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public void likePost(User user, Post post){
        Like like = new Like();
        like.setUser(user);
        like.setPost(post);
        likeRepository.save(like);
    }

    @Override
    public void unlikePost(User user, Post post) {
        Optional<Like> like = likeRepository.findByUserAndPost(user, post);
        like.ifPresent(likeRepository::delete);
    }

    @Override
    public int countLikesByPost(Post post) {
        return likeRepository.countByPost(post);
    }
}

package com.anthonytabet.portfol.repository;

import com.anthonytabet.portfol.model.Like;
import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserAndPost(User user, Post post);

    int countByPost(Post post);
}

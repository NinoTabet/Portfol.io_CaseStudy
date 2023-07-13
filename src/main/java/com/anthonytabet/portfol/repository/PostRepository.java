package com.anthonytabet.portfol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anthonytabet.portfol.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
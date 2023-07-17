package com.anthonytabet.portfol.service;

import com.anthonytabet.portfol.model.Post;
import org.springframework.web.multipart.MultipartFile;

public interface PostService {
    void createPost(MultipartFile photo, String description);
    Post findById(Long id);
}
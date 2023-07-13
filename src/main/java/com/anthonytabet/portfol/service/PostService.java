package com.anthonytabet.portfol.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface PostService {
    void createPost(MultipartFile photo, String description);
}
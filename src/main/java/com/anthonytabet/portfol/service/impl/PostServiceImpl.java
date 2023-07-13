package com.anthonytabet.portfol.service.impl;

import com.anthonytabet.portfol.model.Post;
import com.anthonytabet.portfol.repository.PostRepository;
import com.anthonytabet.portfol.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

//PostServiceImpl is used for creating new posts
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    @Override
    public void createPost(MultipartFile photo, String description) {
        try {
            // Add timestamp to the file name to ensure it's unique
            String originalFileName = photo.getOriginalFilename();
            String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileNameWithoutExtension = originalFileName.substring(0, originalFileName.lastIndexOf("."));
            String uniqueFileName = fileNameWithoutExtension + "_" + Instant.now().toEpochMilli() + fileExtension;

            // Save photo file to the file system and get the path
            byte[] bytes = photo.getBytes();
            Path path = Paths.get("src/main/resources/static/posts/" + uniqueFileName);
            Files.write(path, bytes);

            // Create post object
            Post post = new Post();
            post.setPhoto(uniqueFileName); // store only the file name
            post.setDescription(description);

            // Save post to the database
            postRepository.save(post);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create post", e);
        }
    }

}

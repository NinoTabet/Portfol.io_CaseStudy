package com.anthonytabet.portfol.repository;

import com.anthonytabet.portfol.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testFindByPostId() {
        // Here you'll need to create and save a Post and a Comment associated with that Post before this test. Do not create associated posts and comments to fail this test.
        Long postId = 1L; // Replace with actual postId
        List<Comment> comments = commentRepository.findByPostId(postId);
        assertThat(comments).isNotEmpty();
    }
}
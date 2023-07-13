package com.anthonytabet.portfol.repository;

import com.anthonytabet.portfol.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testSavePost() {
        //To fail this test, change isNotNull to isNull. This test should pass as it is now because the post is created and returns a notNull value
        Post post = new Post();
        postRepository.save(post);
        Post foundPost = postRepository.findById(post.getId()).orElse(null);
        assertThat(foundPost).isNotNull();
    }
}
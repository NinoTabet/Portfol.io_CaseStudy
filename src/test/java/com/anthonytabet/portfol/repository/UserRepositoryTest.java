package com.anthonytabet.portfol.repository;

import com.anthonytabet.portfol.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // put email that is found in database to pass this test, put incorrect email to fail this test.
        String email = "yeet@yeet.yeet";
        User user = userRepository.findByEmail(email);
        assertThat(user).isNotNull();
    }
}
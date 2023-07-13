package com.anthonytabet.portfol.repository;

import com.anthonytabet.portfol.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testFindByName() {
        //This test should fail as there is no Role_User. To pass this test, please change ROLE_USER to ROLE_ADMIN
        String roleName = "ROLE_USER";
        Role role = roleRepository.findByName(roleName);
        assertThat(role).isNull();
    }
}
package com.anthonytabet.portfol.repository;

import com.anthonytabet.portfol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1 ")
    User findByEmail(String email);
    Optional<User> findById(Long id);

}

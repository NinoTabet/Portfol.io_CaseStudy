package com.anthonytabet.portfol.service;

import com.anthonytabet.portfol.dto.UserDto;
import com.anthonytabet.portfol.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

}

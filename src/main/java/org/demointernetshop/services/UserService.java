package org.demointernetshop.services;

import org.demointernetshop.dto.user.UserRegistrationDto;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.dto.user.UserUpdateDto;

public interface UserService {
    UserDto getUserById(Integer userId);

    UserDto updateUser(Integer userId, UserUpdateDto request);
    UserDto createUser(UserRegistrationDto request);
}

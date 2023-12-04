package org.demointernetshop.controllers;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.controllers.api.UsersApi;
import org.demointernetshop.dto.user.UserRegistrationDto;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.dto.user.UserUpdateDto;
import org.demointernetshop.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {
    private final UserService userService;

    @Override
    public UserDto register(UserRegistrationDto request) {
        return userService.createUser(request);
    }

    @Override
    public UserDto updateUser(UserUpdateDto request, Integer userId) {
        return userService.updateUser(userId, request);
    }

    @Override
    public UserDto getUser(Integer userId) {
        return userService.getUserById(userId);
    }

    @Override
    public UserDto archived(Integer userId) {
        return null;
    }
}

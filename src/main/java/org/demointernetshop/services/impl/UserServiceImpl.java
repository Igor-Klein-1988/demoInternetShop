package org.demointernetshop.services.impl;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.dto.user.UserRegistrationDto;
import org.demointernetshop.dto.user.UserDto;
import org.demointernetshop.dto.user.UserUpdateDto;
import org.demointernetshop.entity.Role;
import org.demointernetshop.entity.User;
import org.demointernetshop.exceptions.RestException;
import org.demointernetshop.repository.RoleRepository;
import org.demointernetshop.repository.UserRepository;
import org.demointernetshop.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                "Manager with Email: <" + userId + "> not found"));
        return UserDto.from(user);
    }

    @Override
    public UserDto createUser(UserRegistrationDto request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Username already taken");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        Role clientRole = roleRepository.findByName(Role.Roles.CLIENT)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Role with name: <" + Role.Roles.CLIENT + "> not found"));
        User newUser = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .role(clientRole)
                .createData(LocalDateTime.now())
                .lastVisitData(LocalDateTime.now())
                .build();
        User savedUser = userRepository.save(newUser);

        return UserDto.from(savedUser);
    }

    @Override
    public UserDto updateUser(Integer userId, UserUpdateDto request) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                "User with id: <" + userId + "> not found"));
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Username already taken");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RestException(HttpStatus.BAD_REQUEST, "Email already in use");
        }
        Role clientRole = roleRepository.findByName(Role.Roles.CLIENT)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND,
                        "Role with name: <" + Role.Roles.CLIENT + "> not found"));
        User newUser = User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .phone(request.getPhone())
                .role(clientRole)
                .createData(LocalDateTime.now())
                .lastVisitData(LocalDateTime.now())
                .build();
        User savedUser = userRepository.save(newUser);

        return UserDto.from(savedUser);
    }
}

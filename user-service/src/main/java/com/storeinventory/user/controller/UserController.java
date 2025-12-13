package com.storeinventory.user.controller;

import com.storeinventory.user.dto.UserDto;
import com.storeinventory.user.model.User;
import com.storeinventory.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        User user = toEntity(userDto);
        User savedUser = repo.save(user);
        return toDto(savedUser);
    }

    @GetMapping("/get-user")
    public List<UserDto> listUsers() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        User user = repo.findByUsername(username);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDto(user));
    }

    private UserDto toDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getRole());
    }

    private User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }
}

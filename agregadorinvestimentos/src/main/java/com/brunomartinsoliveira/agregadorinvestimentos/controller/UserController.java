package com.brunomartinsoliveira.agregadorinvestimentos.controller;

import com.brunomartinsoliveira.agregadorinvestimentos.dto.CreateUserDto;
import com.brunomartinsoliveira.agregadorinvestimentos.entity.User;
import com.brunomartinsoliveira.agregadorinvestimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto createUserDto) {
        UUID userId = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + userId)).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        // lógica para buscar e retornar usuário
        return null;
    }
}

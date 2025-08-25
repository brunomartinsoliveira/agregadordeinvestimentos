package com.brunomartinsoliveira.agregadorinvestimentos.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.brunomartinsoliveira.agregadorinvestimentos.dto.CreateUserDto;
import com.brunomartinsoliveira.agregadorinvestimentos.entity.User;
import com.brunomartinsoliveira.agregadorinvestimentos.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        var entity = new User(
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password());

        var userSaved = userRepository.save(entity);
        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId) {

        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listUsers() {

        return userRepository.findAll();
    }
}

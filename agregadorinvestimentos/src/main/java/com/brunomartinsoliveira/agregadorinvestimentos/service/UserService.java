package com.brunomartinsoliveira.agregadorinvestimentos.service;

import com.brunomartinsoliveira.agregadorinvestimentos.dto.CreateUserDto;
import com.brunomartinsoliveira.agregadorinvestimentos.entity.User;
import com.brunomartinsoliveira.agregadorinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

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
                createUserDto.password()
        );

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }
}

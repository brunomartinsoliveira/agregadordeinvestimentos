package com.brunomartinsoliveira.agregadorinvestimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brunomartinsoliveira.agregadorinvestimentos.entity.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
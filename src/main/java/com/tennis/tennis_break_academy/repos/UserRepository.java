package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.UserEntiy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntiy, Integer> {
    Optional<UserEntiy> findByusername(String username);
    Boolean existsByUsername(String username);
}

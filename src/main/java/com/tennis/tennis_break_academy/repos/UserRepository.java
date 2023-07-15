package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}

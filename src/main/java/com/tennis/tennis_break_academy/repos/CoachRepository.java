package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.Coach;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoachRepository extends JpaRepository<Coach, Integer> {
}

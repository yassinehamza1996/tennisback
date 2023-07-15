package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.ReservationCours;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationCoursRepository extends JpaRepository<ReservationCours, Integer> {
}

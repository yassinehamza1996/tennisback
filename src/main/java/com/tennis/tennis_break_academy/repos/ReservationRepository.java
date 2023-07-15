package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}

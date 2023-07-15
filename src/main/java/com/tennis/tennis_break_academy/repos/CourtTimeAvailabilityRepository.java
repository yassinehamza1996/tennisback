package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.CourtTimeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourtTimeAvailabilityRepository extends JpaRepository<CourtTimeAvailability, Integer> {
}

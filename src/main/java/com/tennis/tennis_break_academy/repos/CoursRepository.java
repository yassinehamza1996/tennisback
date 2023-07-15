package com.tennis.tennis_break_academy.repos;

import com.tennis.tennis_break_academy.domain.Cours;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoursRepository extends JpaRepository<Cours, Integer> {
}

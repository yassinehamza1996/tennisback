package com.tennis.tennis_break_academy.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tennis.tennis_break_academy.domain.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByRoleName(String roleName);
}

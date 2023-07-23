package com.tennis.tennis_break_academy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tennis.tennis_break_academy.domain.Role;
import com.tennis.tennis_break_academy.model.RoleDTO;
import com.tennis.tennis_break_academy.repos.RoleRepository;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/save")
    private ResponseEntity<String> saveRole(@RequestBody RoleDTO roleDTO){
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());
        roleRepository.save(role);
        return new ResponseEntity<>("ROLE SAVED SUCCESS", HttpStatus.OK);
    }
}

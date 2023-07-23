package com.tennis.tennis_break_academy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.tennis.tennis_break_academy.domain.Role;
import com.tennis.tennis_break_academy.domain.UserEntiy;
import com.tennis.tennis_break_academy.model.UserDTO;
import com.tennis.tennis_break_academy.repos.RoleRepository;
import com.tennis.tennis_break_academy.repos.UserRepository;
import com.tennis.tennis_break_academy.security.JWTGenerator;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {


    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private JWTGenerator jwtGenerator;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, RoleRepository roleRepository, JWTGenerator jwtGenerator, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtGenerator = jwtGenerator;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("register")
    public ResponseEntity<String> saveUser(@RequestBody  UserDTO userDTO){
        UserEntiy userEntity = new UserEntiy();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setAge(userDTO.getAge());
        userEntity.setCin(userDTO.getCin());
        userEntity.setPhoneNumber(userDTO.getPhoneNumber());
        userEntity.setMailAddress(userDTO.getMailAddress());
        userEntity.setRole("USER");
        List<Role> roleList = new ArrayList<>();
        Role role = roleRepository.findByRoleName("USER").orElseThrow(null);
        roleList.add(role);
        userEntity.setRoles(roleList);
        userRepository.save(userEntity);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    @PostMapping("login")
    public AuthResponseDTO loginUser(@RequestBody UserDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        AuthResponseDTO response = new AuthResponseDTO();
        response.setAccessToken(token);
        response.setTokenType("Bearer ");
        return response;
    }
}

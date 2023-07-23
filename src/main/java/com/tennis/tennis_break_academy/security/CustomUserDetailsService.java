package com.tennis.tennis_break_academy.security;


import com.tennis.tennis_break_academy.domain.Role;
import com.tennis.tennis_break_academy.domain.UserEntiy;
import com.tennis.tennis_break_academy.repos.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    	UserEntiy user =  userRepository.findByusername(s).orElseThrow(()-> new UsernameNotFoundException("username not found "));
        return (UserDetails) new User(user.getMailAddress(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getRoleName())
        ).collect(Collectors.toList());
    }
}
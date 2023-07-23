package com.tennis.tennis_break_academy.service;

import com.tennis.tennis_break_academy.domain.UserEntiy;
import com.tennis.tennis_break_academy.model.UserDTO;
import com.tennis.tennis_break_academy.repos.UserRepository;
import com.tennis.tennis_break_academy.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        final List<UserEntiy> users = userRepository.findAll(Sort.by("idUser"));
        return users.stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .toList();
    }

    public UserDTO get(final Integer idUser) {
        return userRepository.findById(idUser)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final UserDTO userDTO) {
        final UserEntiy user = new UserEntiy();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getIdUser();
    }

    public void update(final Integer idUser, final UserDTO userDTO) {
        final UserEntiy user = userRepository.findById(idUser)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Integer idUser) {
        userRepository.deleteById(idUser);
    }

    private UserDTO mapToDTO(final UserEntiy user, final UserDTO userDTO) {
        userDTO.setIdUser(user.getIdUser());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setAge(user.getAge());
        userDTO.setCin(user.getCin());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setMailAddress(user.getMailAddress());
        userDTO.setRole(user.getRole());
        return userDTO;
    }

    private UserEntiy mapToEntity(final UserDTO userDTO, final UserEntiy user) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setAge(userDTO.getAge());
        user.setCin(userDTO.getCin());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setMailAddress(userDTO.getMailAddress());
        user.setRole(userDTO.getRole());
        return user;
    }

}

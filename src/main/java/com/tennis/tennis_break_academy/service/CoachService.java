package com.tennis.tennis_break_academy.service;

import com.tennis.tennis_break_academy.domain.Coach;
import com.tennis.tennis_break_academy.model.CoachDTO;
import com.tennis.tennis_break_academy.repos.CoachRepository;
import com.tennis.tennis_break_academy.util.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<CoachDTO> getAllCoaches() {
        List<Coach> coaches = coachRepository.findAll();
        return coaches.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public CoachDTO getCoachById(Integer id) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return mapToDTO(coach);
    }

    public Integer createCoach(CoachDTO coachDTO) {
        Coach coach = mapToEntity(coachDTO);
        Coach savedCoach = coachRepository.save(coach);
        return savedCoach.getIdCoach();
    }

    public void updateCoach(Integer id, CoachDTO coachDTO) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(coachDTO, coach);
        coachRepository.save(coach);
    }

    public void deleteCoach(Integer id) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        coachRepository.delete(coach);
    }

    private CoachDTO mapToDTO(Coach coach) {
        CoachDTO coachDTO = new CoachDTO();
        coachDTO.setIdCoach(coach.getIdCoach());
        coachDTO.setCoachName(coach.getCoachName());
        coachDTO.setAge(coach.getAge());
        coachDTO.setCin(coach.getCin());
        coachDTO.setMailAddress(coach.getMailAddress());
        coachDTO.setPhoneNumber(coach.getPhoneNumber());
        coachDTO.setImage(coach.getImage());
        return coachDTO;
    }

    private void mapToEntity(CoachDTO coachDTO, Coach coach) {
        coach.setCoachName(coachDTO.getCoachName());
        coach.setAge(coachDTO.getAge());
        coach.setCin(coachDTO.getCin());
        coach.setMailAddress(coachDTO.getMailAddress());
        coach.setPhoneNumber(coachDTO.getPhoneNumber());
        coach.setImage(coachDTO.getImage());
    }
}

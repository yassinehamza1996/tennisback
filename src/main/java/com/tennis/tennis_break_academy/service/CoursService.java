package com.tennis.tennis_break_academy.service;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tennis.tennis_break_academy.domain.Cours;
import com.tennis.tennis_break_academy.model.CoursDTO;
import com.tennis.tennis_break_academy.repos.CoursRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoursService {

    private final CoursRepository coursRepository;

    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public List<CoursDTO> findAll() {
        List<Cours> coursList = coursRepository.findAll();
        return convertToDTOList(coursList);
    }

    public CoursDTO get(Integer idCours) {
        Optional<Cours> optionalCours = coursRepository.findById(idCours);
        return optionalCours.map(this::convertToDTO).orElse(null);
    }

    public Integer create(CoursDTO coursDTO) {
        Cours cours = convertToEntity(coursDTO);
        coursRepository.save(cours);
        return cours.getIdCours();
    }

    public void update(Integer idCours, CoursDTO coursDTO) {
        Optional<Cours> optionalCours = coursRepository.findById(idCours);
        optionalCours.ifPresent(cours -> {
            BeanUtils.copyProperties(coursDTO, cours, "idCours");
            coursRepository.save(cours);
        });
    }

    public void delete(Integer idCours) {
        coursRepository.deleteById(idCours);
    }

    public void deleteAll(List<Integer> coursList) {
        coursList.forEach(this::delete);
    }

    private CoursDTO convertToDTO(Cours cours) {
        CoursDTO coursDTO = new CoursDTO();
        BeanUtils.copyProperties(cours, coursDTO);
        return coursDTO;
    }

    private List<CoursDTO> convertToDTOList(List<Cours> coursList) {
        List<CoursDTO> coursDTOList = new ArrayList<>();
        for (Cours cours : coursList) {
            coursDTOList.add(convertToDTO(cours));
        }
        return coursDTOList;
    }

    private Cours convertToEntity(CoursDTO coursDTO) {
        Cours cours = new Cours();
        BeanUtils.copyProperties(coursDTO, cours);
        return cours;
    }
}

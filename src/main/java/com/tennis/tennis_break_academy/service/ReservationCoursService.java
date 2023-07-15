package com.tennis.tennis_break_academy.service;

import com.tennis.tennis_break_academy.domain.ReservationCours;
import com.tennis.tennis_break_academy.model.ReservationCoursDTO;
import com.tennis.tennis_break_academy.repos.ReservationCoursRepository;
import com.tennis.tennis_break_academy.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ReservationCoursService {

    private final ReservationCoursRepository reservationCoursRepository;

    public ReservationCoursService(final ReservationCoursRepository reservationCoursRepository) {
        this.reservationCoursRepository = reservationCoursRepository;
    }

    public List<ReservationCoursDTO> findAll() {
        final List<ReservationCours> reservationCourss = reservationCoursRepository.findAll(Sort.by("idReservationCours"));
        return reservationCourss.stream()
                .map(reservationCours -> mapToDTO(reservationCours, new ReservationCoursDTO()))
                .toList();
    }

    public ReservationCoursDTO get(final Integer idReservationCours) {
        return reservationCoursRepository.findById(idReservationCours)
                .map(reservationCours -> mapToDTO(reservationCours, new ReservationCoursDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final ReservationCoursDTO reservationCoursDTO) {
        final ReservationCours reservationCours = new ReservationCours();
        mapToEntity(reservationCoursDTO, reservationCours);
        return reservationCoursRepository.save(reservationCours).getIdReservationCours();
    }

    public void update(final Integer idReservationCours,
            final ReservationCoursDTO reservationCoursDTO) {
        final ReservationCours reservationCours = reservationCoursRepository.findById(idReservationCours)
                .orElseThrow(NotFoundException::new);
        mapToEntity(reservationCoursDTO, reservationCours);
        reservationCoursRepository.save(reservationCours);
    }

    public void delete(final Integer idReservationCours) {
        reservationCoursRepository.deleteById(idReservationCours);
    }

    private ReservationCoursDTO mapToDTO(final ReservationCours reservationCours,
            final ReservationCoursDTO reservationCoursDTO) {
        reservationCoursDTO.setIdReservationCours(reservationCours.getIdReservationCours());
        return reservationCoursDTO;
    }

    private ReservationCours mapToEntity(final ReservationCoursDTO reservationCoursDTO,
            final ReservationCours reservationCours) {
        return reservationCours;
    }

}

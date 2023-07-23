package com.tennis.tennis_break_academy.service;

import com.tennis.tennis_break_academy.domain.Reservation;
import com.tennis.tennis_break_academy.domain.Terrain;
import com.tennis.tennis_break_academy.domain.UserEntiy;
import com.tennis.tennis_break_academy.model.ReservationDTO;
import com.tennis.tennis_break_academy.repos.ReservationRepository;
import com.tennis.tennis_break_academy.repos.TerrainRepository;
import com.tennis.tennis_break_academy.repos.UserRepository;
import com.tennis.tennis_break_academy.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TerrainRepository terrainRepository;
    private final UserRepository userRepository;

    public ReservationService(final ReservationRepository reservationRepository,
            final TerrainRepository terrainRepository, final UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.terrainRepository = terrainRepository;
        this.userRepository = userRepository;
    }

    public List<ReservationDTO> findAll() {
        final List<Reservation> reservations = reservationRepository.findAll(Sort.by("idReservation"));
        return reservations.stream()
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .toList();
    }

    public ReservationDTO get(final Integer idReservation) {
        return reservationRepository.findById(idReservation)
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final ReservationDTO reservationDTO) {
        final Reservation reservation = new Reservation();
        mapToEntity(reservationDTO, reservation);
        return reservationRepository.save(reservation).getIdReservation();
    }

    public void update(final Integer idReservation, final ReservationDTO reservationDTO) {
        final Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(NotFoundException::new);
        mapToEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);
    }

    public void delete(final Integer idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    private ReservationDTO mapToDTO(final Reservation reservation,
            final ReservationDTO reservationDTO) {
        reservationDTO.setIdReservation(reservation.getIdReservation());
        reservationDTO.setIdUser(reservation.getIdUser());
        reservationDTO.setStartDate(reservation.getStartDate());
        reservationDTO.setEndDate(reservation.getEndDate());
        reservationDTO.setIdTerrain(reservation.getIdTerrain() == null ? null : reservation.getIdTerrain().getIdTerrain());
        reservationDTO.setUserId(reservation.getUserId() == null ? null : reservation.getUserId().getIdUser());
        return reservationDTO;
    }

    private Reservation mapToEntity(final ReservationDTO reservationDTO,
            final Reservation reservation) {
        reservation.setIdUser(reservationDTO.getIdUser());
        reservation.setStartDate(reservationDTO.getStartDate());
        reservation.setEndDate(reservationDTO.getEndDate());
        final Terrain idTerrain = reservationDTO.getIdTerrain() == null ? null : terrainRepository.findById(reservationDTO.getIdTerrain())
                .orElseThrow(() -> new NotFoundException("idTerrain not found"));
        reservation.setIdTerrain(idTerrain);
        final UserEntiy userId = reservationDTO.getUserId() == null ? null : userRepository.findById(reservationDTO.getUserId())
                .orElseThrow(() -> new NotFoundException("userId not found"));
        reservation.setUserId(userId);
        return reservation;
    }

}

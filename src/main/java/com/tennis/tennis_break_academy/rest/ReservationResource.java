package com.tennis.tennis_break_academy.rest;

import com.tennis.tennis_break_academy.model.ReservationDTO;
import com.tennis.tennis_break_academy.service.ReservationService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationResource {

    private final ReservationService reservationService;

    public ReservationResource(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/{idReservation}")
    public ResponseEntity<ReservationDTO> getReservation(
            @PathVariable(name = "idReservation") final Integer idReservation) {
        return ResponseEntity.ok(reservationService.get(idReservation));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createReservation(
            @RequestBody @Valid final ReservationDTO reservationDTO) {
        final Integer createdIdReservation = reservationService.create(reservationDTO);
        return new ResponseEntity<>(createdIdReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{idReservation}")
    public ResponseEntity<Void> updateReservation(
            @PathVariable(name = "idReservation") final Integer idReservation,
            @RequestBody @Valid final ReservationDTO reservationDTO) {
        reservationService.update(idReservation, reservationDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idReservation}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable(name = "idReservation") final Integer idReservation) {
        reservationService.delete(idReservation);
        return ResponseEntity.noContent().build();
    }

}

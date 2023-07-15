package com.tennis.tennis_break_academy.rest;

import com.tennis.tennis_break_academy.model.ReservationCoursDTO;
import com.tennis.tennis_break_academy.service.ReservationCoursService;
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
@RequestMapping(value = "/api/reservationCourss", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationCoursResource {

    private final ReservationCoursService reservationCoursService;

    public ReservationCoursResource(final ReservationCoursService reservationCoursService) {
        this.reservationCoursService = reservationCoursService;
    }

    @GetMapping
    public ResponseEntity<List<ReservationCoursDTO>> getAllReservationCourss() {
        return ResponseEntity.ok(reservationCoursService.findAll());
    }

    @GetMapping("/{idReservationCours}")
    public ResponseEntity<ReservationCoursDTO> getReservationCours(
            @PathVariable(name = "idReservationCours") final Integer idReservationCours) {
        return ResponseEntity.ok(reservationCoursService.get(idReservationCours));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createReservationCours(
            @RequestBody @Valid final ReservationCoursDTO reservationCoursDTO) {
        final Integer createdIdReservationCours = reservationCoursService.create(reservationCoursDTO);
        return new ResponseEntity<>(createdIdReservationCours, HttpStatus.CREATED);
    }

    @PutMapping("/{idReservationCours}")
    public ResponseEntity<Void> updateReservationCours(
            @PathVariable(name = "idReservationCours") final Integer idReservationCours,
            @RequestBody @Valid final ReservationCoursDTO reservationCoursDTO) {
        reservationCoursService.update(idReservationCours, reservationCoursDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idReservationCours}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteReservationCours(
            @PathVariable(name = "idReservationCours") final Integer idReservationCours) {
        reservationCoursService.delete(idReservationCours);
        return ResponseEntity.noContent().build();
    }

}

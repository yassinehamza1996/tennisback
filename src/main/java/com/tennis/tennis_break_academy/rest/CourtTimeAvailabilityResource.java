package com.tennis.tennis_break_academy.rest;

import com.tennis.tennis_break_academy.model.CourtTimeAvailabilityDTO;
import com.tennis.tennis_break_academy.service.CourtTimeAvailabilityService;
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
@RequestMapping(value = "/api/courtTimeAvailabilitys", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourtTimeAvailabilityResource {

    private final CourtTimeAvailabilityService courtTimeAvailabilityService;

    public CourtTimeAvailabilityResource(
            final CourtTimeAvailabilityService courtTimeAvailabilityService) {
        this.courtTimeAvailabilityService = courtTimeAvailabilityService;
    }

    @GetMapping
    public ResponseEntity<List<CourtTimeAvailabilityDTO>> getAllCourtTimeAvailabilitys() {
        return ResponseEntity.ok(courtTimeAvailabilityService.findAll());
    }

    @GetMapping("/{idCourtTimeAvailability}")
    public ResponseEntity<CourtTimeAvailabilityDTO> getCourtTimeAvailability(
            @PathVariable(name = "idCourtTimeAvailability") final Integer idCourtTimeAvailability) {
        return ResponseEntity.ok(courtTimeAvailabilityService.get(idCourtTimeAvailability));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createCourtTimeAvailability(
            @RequestBody @Valid final CourtTimeAvailabilityDTO courtTimeAvailabilityDTO) {
        final Integer createdIdCourtTimeAvailability = courtTimeAvailabilityService.create(courtTimeAvailabilityDTO);
        return new ResponseEntity<>(createdIdCourtTimeAvailability, HttpStatus.CREATED);
    }

    @PutMapping("/{idCourtTimeAvailability}")
    public ResponseEntity<Void> updateCourtTimeAvailability(
            @PathVariable(name = "idCourtTimeAvailability") final Integer idCourtTimeAvailability,
            @RequestBody @Valid final CourtTimeAvailabilityDTO courtTimeAvailabilityDTO) {
        courtTimeAvailabilityService.update(idCourtTimeAvailability, courtTimeAvailabilityDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCourtTimeAvailability}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCourtTimeAvailability(
            @PathVariable(name = "idCourtTimeAvailability") final Integer idCourtTimeAvailability) {
        courtTimeAvailabilityService.delete(idCourtTimeAvailability);
        return ResponseEntity.noContent().build();
    }

}

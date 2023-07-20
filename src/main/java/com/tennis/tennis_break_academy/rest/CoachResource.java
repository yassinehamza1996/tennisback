package com.tennis.tennis_break_academy.rest;

import com.tennis.tennis_break_academy.model.CoachDTO;
import com.tennis.tennis_break_academy.service.CoachService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coaches", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class CoachResource {

    private final CoachService coachService;

    public CoachResource(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public ResponseEntity<List<CoachDTO>> getAllCoaches() {
        return ResponseEntity.ok(coachService.getAllCoaches());
    }

    @GetMapping("/{idCoach}")
    public ResponseEntity<CoachDTO> getCoach(@PathVariable(name = "idCoach") final Integer idCoach) {
        return ResponseEntity.ok(coachService.getCoachById(idCoach));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createCoach(@RequestBody @Valid final CoachDTO coachDTO) {
        final Integer createdIdCoach = coachService.createCoach(coachDTO);
        return new ResponseEntity<>(createdIdCoach, HttpStatus.CREATED);
    }

    @PutMapping("/{idCoach}")
    public ResponseEntity<Void> updateCoach(@PathVariable(name = "idCoach") final Integer idCoach,
                                            @RequestBody @Valid final CoachDTO coachDTO) {
        coachService.updateCoach(idCoach, coachDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCoach}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCoach(@PathVariable(name = "idCoach") final Integer idCoach) {
        coachService.deleteCoach(idCoach);
        return ResponseEntity.noContent().build();
    }

}


package com.tennis.tennis_break_academy.rest;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tennis.tennis_break_academy.model.CoursDTO;
import com.tennis.tennis_break_academy.service.CoursService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cours", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class CoursResource {

    private final CoursService coursService;

    public CoursResource(final CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping
    public ResponseEntity<List<CoursDTO>> getAllCours() {
        return ResponseEntity.ok(coursService.findAll());
    }

    @GetMapping("/{idCours}")
    public ResponseEntity<CoursDTO> getCours(
            @PathVariable(name = "idCours") final Integer idCours) {
        return ResponseEntity.ok(coursService.get(idCours));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createCours(@RequestBody @Valid final CoursDTO coursDTO) {
        final Integer createdIdCours = coursService.create(coursDTO);
        return new ResponseEntity<>(createdIdCours, HttpStatus.CREATED);
    }

    @PutMapping("/{idCours}")
    public ResponseEntity<Void> updateCours(
            @PathVariable(name = "idCours") final Integer idCours,
            @RequestBody @Valid final CoursDTO coursDTO) {
        coursService.update(idCours, coursDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idCours}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCours(
            @PathVariable(name = "idCours") final Integer idCours) {
        coursService.delete(idCours);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAll")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteAll(@RequestBody List<Integer> coursList) {
        coursService.deleteAll(coursList);
        return ResponseEntity.noContent().build();
    }
}

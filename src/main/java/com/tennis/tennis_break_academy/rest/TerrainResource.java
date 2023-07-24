package com.tennis.tennis_break_academy.rest;

import com.tennis.tennis_break_academy.model.TerrainDTO;
import com.tennis.tennis_break_academy.service.TerrainService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/terrains", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class TerrainResource {

    private final TerrainService terrainService;

    public TerrainResource(final TerrainService terrainService) {
        this.terrainService = terrainService;
    }

    @GetMapping
    public ResponseEntity<List<TerrainDTO>> getAllTerrains() {
        return ResponseEntity.ok(terrainService.findAll());
    }

    @GetMapping("/{idTerrain}")
    public ResponseEntity<TerrainDTO> getTerrain(
            @PathVariable(name = "idTerrain") final Integer idTerrain) {
        return ResponseEntity.ok(terrainService.get(idTerrain));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Integer> createTerrain(@RequestBody @Valid final TerrainDTO terrainDTO) {
        final Integer createdIdTerrain = terrainService.create(terrainDTO);
        return new ResponseEntity<>(createdIdTerrain, HttpStatus.CREATED);
    }

    @PutMapping("/{idTerrain}")
    public ResponseEntity<Void> updateTerrain(
            @PathVariable(name = "idTerrain") final Integer idTerrain,
            @RequestBody @Valid final TerrainDTO terrainDTO) {
        terrainService.update(idTerrain, terrainDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idTerrain}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteTerrain(
            @PathVariable(name = "idTerrain") final Integer idTerrain) {
        terrainService.delete(idTerrain);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteAll")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteAll(@RequestBody List<Integer> courtList) {
    	terrainService.deleteAll(courtList);
        return ResponseEntity.noContent().build();
    }
}

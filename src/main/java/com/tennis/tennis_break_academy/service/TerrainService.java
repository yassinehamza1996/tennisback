package com.tennis.tennis_break_academy.service;

import com.tennis.tennis_break_academy.domain.Terrain;
import com.tennis.tennis_break_academy.model.TerrainDTO;
import com.tennis.tennis_break_academy.repos.TerrainRepository;
import com.tennis.tennis_break_academy.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class TerrainService {

    private final TerrainRepository terrainRepository;

    public TerrainService(final TerrainRepository terrainRepository) {
        this.terrainRepository = terrainRepository;
    }

    public List<TerrainDTO> findAll() {
        final List<Terrain> terrains = terrainRepository.findAll(Sort.by("idTerrain"));
        return terrains.stream()
                .map(terrain -> mapToDTO(terrain, new TerrainDTO()))
                .toList();
    }

    public TerrainDTO get(final Integer idTerrain) {
        return terrainRepository.findById(idTerrain)
                .map(terrain -> mapToDTO(terrain, new TerrainDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final TerrainDTO terrainDTO) {
        final Terrain terrain = new Terrain();
        mapToEntity(terrainDTO, terrain);
        return terrainRepository.save(terrain).getIdTerrain();
    }

    public void update(final Integer idTerrain, final TerrainDTO terrainDTO) {
        final Terrain terrain = terrainRepository.findById(idTerrain)
                .orElseThrow(NotFoundException::new);
        mapToEntity(terrainDTO, terrain);
        terrainRepository.save(terrain);
    }

    public void delete(final Integer idTerrain) {
        terrainRepository.deleteById(idTerrain);
    }

    private TerrainDTO mapToDTO(final Terrain terrain, final TerrainDTO terrainDTO) {
        terrainDTO.setIdTerrain(terrain.getIdTerrain());
        terrainDTO.setCapacity(terrain.getCapacity());
        terrainDTO.setStatus(terrain.getStatus());
        terrainDTO.setPrice(terrain.getPrice());
        terrainDTO.setDescription(terrain.getDescription());
        return terrainDTO;
    }

    private Terrain mapToEntity(final TerrainDTO terrainDTO, final Terrain terrain) {
        terrain.setCapacity(terrainDTO.getCapacity());
        terrain.setStatus(terrainDTO.getStatus());
        terrain.setPrice(terrainDTO.getPrice());
        terrain.setDescription(terrainDTO.getDescription());
        return terrain;
    }

}

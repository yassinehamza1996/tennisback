package com.tennis.tennis_break_academy.service;

import com.tennis.tennis_break_academy.domain.CourtTimeAvailability;
import com.tennis.tennis_break_academy.domain.Terrain;
import com.tennis.tennis_break_academy.model.CourtTimeAvailabilityDTO;
import com.tennis.tennis_break_academy.repos.CourtTimeAvailabilityRepository;
import com.tennis.tennis_break_academy.repos.TerrainRepository;
import com.tennis.tennis_break_academy.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CourtTimeAvailabilityService {

    private final CourtTimeAvailabilityRepository courtTimeAvailabilityRepository;
    private final TerrainRepository terrainRepository;

    public CourtTimeAvailabilityService(
            final CourtTimeAvailabilityRepository courtTimeAvailabilityRepository,
            final TerrainRepository terrainRepository) {
        this.courtTimeAvailabilityRepository = courtTimeAvailabilityRepository;
        this.terrainRepository = terrainRepository;
    }

    public List<CourtTimeAvailabilityDTO> findAll() {
        final List<CourtTimeAvailability> courtTimeAvailabilitys = courtTimeAvailabilityRepository.findAll(Sort.by("idCourtTimeAvailability"));
        return courtTimeAvailabilitys.stream()
                .map(courtTimeAvailability -> mapToDTO(courtTimeAvailability, new CourtTimeAvailabilityDTO()))
                .toList();
    }

    public CourtTimeAvailabilityDTO get(final Integer idCourtTimeAvailability) {
        return courtTimeAvailabilityRepository.findById(idCourtTimeAvailability)
                .map(courtTimeAvailability -> mapToDTO(courtTimeAvailability, new CourtTimeAvailabilityDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(final CourtTimeAvailabilityDTO courtTimeAvailabilityDTO) {
        final CourtTimeAvailability courtTimeAvailability = new CourtTimeAvailability();
        mapToEntity(courtTimeAvailabilityDTO, courtTimeAvailability);
        return courtTimeAvailabilityRepository.save(courtTimeAvailability).getIdCourtTimeAvailability();
    }

    public void update(final Integer idCourtTimeAvailability,
            final CourtTimeAvailabilityDTO courtTimeAvailabilityDTO) {
        final CourtTimeAvailability courtTimeAvailability = courtTimeAvailabilityRepository.findById(idCourtTimeAvailability)
                .orElseThrow(NotFoundException::new);
        mapToEntity(courtTimeAvailabilityDTO, courtTimeAvailability);
        courtTimeAvailabilityRepository.save(courtTimeAvailability);
    }

    public void delete(final Integer idCourtTimeAvailability) {
        courtTimeAvailabilityRepository.deleteById(idCourtTimeAvailability);
    }

    private CourtTimeAvailabilityDTO mapToDTO(final CourtTimeAvailability courtTimeAvailability,
            final CourtTimeAvailabilityDTO courtTimeAvailabilityDTO) {
        courtTimeAvailabilityDTO.setIdCourtTimeAvailability(courtTimeAvailability.getIdCourtTimeAvailability());
        courtTimeAvailabilityDTO.setDayWeek(courtTimeAvailability.getDayWeek());
        courtTimeAvailabilityDTO.setStartDate(courtTimeAvailability.getStartDate());
        courtTimeAvailabilityDTO.setEndDate(courtTimeAvailability.getEndDate());
        courtTimeAvailabilityDTO.setRange(courtTimeAvailability.getRange());
        courtTimeAvailabilityDTO.setTerrainId(courtTimeAvailability.getTerrainId() == null ? null : courtTimeAvailability.getTerrainId().getIdTerrain());
        return courtTimeAvailabilityDTO;
    }

    private CourtTimeAvailability mapToEntity(
            final CourtTimeAvailabilityDTO courtTimeAvailabilityDTO,
            final CourtTimeAvailability courtTimeAvailability) {
        courtTimeAvailability.setDayWeek(courtTimeAvailabilityDTO.getDayWeek());
        courtTimeAvailability.setStartDate(courtTimeAvailabilityDTO.getStartDate());
        courtTimeAvailability.setEndDate(courtTimeAvailabilityDTO.getEndDate());
        courtTimeAvailability.setRange(courtTimeAvailabilityDTO.getRange());
        final Terrain terrainId = courtTimeAvailabilityDTO.getTerrainId() == null ? null : terrainRepository.findById(courtTimeAvailabilityDTO.getTerrainId())
                .orElseThrow(() -> new NotFoundException("terrainId not found"));
        courtTimeAvailability.setTerrainId(terrainId);
        return courtTimeAvailability;
    }

}

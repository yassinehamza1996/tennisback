package com.tennis.tennis_break_academy.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;


public class CourtTimeAvailabilityDTO {

    private Integer idCourtTimeAvailability;

    @Size(max = 255)
    private String dayWeek;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer range;

    private Integer terrainId;

    public Integer getIdCourtTimeAvailability() {
        return idCourtTimeAvailability;
    }

    public void setIdCourtTimeAvailability(final Integer idCourtTimeAvailability) {
        this.idCourtTimeAvailability = idCourtTimeAvailability;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(final String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(final Integer range) {
        this.range = range;
    }

    public Integer getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(final Integer terrainId) {
        this.terrainId = terrainId;
    }

}

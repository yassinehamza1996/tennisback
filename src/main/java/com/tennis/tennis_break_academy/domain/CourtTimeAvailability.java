package com.tennis.tennis_break_academy.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;


@Entity
public class CourtTimeAvailability {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCourtTimeAvailability;

    @Column
    private String dayWeek;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column(name = "\"range\"")
    private Integer range;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terrain_id_id")
    private Terrain terrainId;

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

    public Terrain getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(final Terrain terrainId) {
        this.terrainId = terrainId;
    }

}

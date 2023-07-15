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
public class ClosedCourt {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCloseCourt;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private String cause;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terrain_id")
    private Terrain idTerrain;

    public Integer getIdCloseCourt() {
        return idCloseCourt;
    }

    public void setIdCloseCourt(final Integer idCloseCourt) {
        this.idCloseCourt = idCloseCourt;
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

    public String getCause() {
        return cause;
    }

    public void setCause(final String cause) {
        this.cause = cause;
    }

    public Terrain getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(final Terrain idTerrain) {
        this.idTerrain = idTerrain;
    }

}

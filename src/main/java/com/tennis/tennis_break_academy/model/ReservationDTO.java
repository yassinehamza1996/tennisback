package com.tennis.tennis_break_academy.model;

import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;


public class ReservationDTO {

    private Integer idReservation;

    @Size(max = 255)
    private String idUser;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer idTerrain;

    private Integer userId;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(final Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(final String idUser) {
        this.idUser = idUser;
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

    public Integer getIdTerrain() {
        return idTerrain;
    }

    public void setIdTerrain(final Integer idTerrain) {
        this.idTerrain = idTerrain;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

}
